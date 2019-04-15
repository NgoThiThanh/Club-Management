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
import thanh.beans.UserBean;
import thanh.beans.User_ContestBean;
import thanh.consts.PageLinkConstants;

/**
 *
 * @author Short Corn
 */
public class DeleteUserController extends HttpServlet {

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
        String url=PageLinkConstants.ERROR;
        try {
            String username=request.getParameter("txtUsername");
            System.out.println("id "+username);
            UserBean bean=new UserBean();
            User_ContestBean bean2=new User_ContestBean();
            bean.setUsername(username);
            bean2.setUsername(username);
            
            boolean check1=bean2.deleteByUsername();
            boolean check2=bean.deleteUser();
            System.out.println("check1:"+check1+"check2"+check2);
            if(check2){
                if(!request.getParameter("txtSearchUser").equals("")){
                    System.out.println("del1: "+request.getParameter("txtSearchUser"));
                    url=PageLinkConstants.USERSEARCHSUCCESS;
                }else if(request.getParameter("txtSearchUser").equals("")){
                    
                    url=PageLinkConstants.LOADUSERDATA;
                    System.out.println("del2: "+request.getParameter("txtSearchUser"));
                }
                
            }else{
                request.setAttribute("ERROR", "Delete failed.");
            }
        } catch (Exception e) {
            log("error at deleteUserController: "+e.getMessage());
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
