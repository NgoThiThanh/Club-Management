/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thanh.beans.User_ContestBean;
import thanh.consts.PageLinkConstants;
import thanh.dtos.User_ContestDTO;

/**
 *
 * @author Short Corn
 */
public class UserRegistContestController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = PageLinkConstants.ERROR;
        try {
            HttpSession session=request.getSession();
            String txtContestId=request.getParameter("txtContestId");
            String username=(String) session.getAttribute("CURRENT_USER");
            
            if(username==null){
                url="login.jsp";
            }else{
                User_ContestDTO dto=new User_ContestDTO(username, txtContestId, "None");
                User_ContestBean bean =new User_ContestBean();
                bean.setDto(dto);
                boolean check=bean.insertUserAndContest();
                if(check){
                    url=PageLinkConstants.LOADDATACONTESTINFO;
                    request.setAttribute("INVALID", "Regist successfully!");
                }
            }
            
        } catch (Exception e) {
            
            log("Error at UserRegistContestController: "+e.getMessage());
            if(e.getMessage().contains("duplicate")){
                request.setAttribute("INVALID", "You have registed this contest!");
                url=PageLinkConstants.LOADDATACONTESTINFO;
            }
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
