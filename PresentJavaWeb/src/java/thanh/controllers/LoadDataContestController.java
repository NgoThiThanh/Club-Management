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
import thanh.beans.ContestBean;
import thanh.consts.PageLinkConstants;

/**
 *
 * @author Short Corn
 */
public class LoadDataContestController extends HttpServlet {

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
        try {
            
            System.out.println("come here");
            int pageId = 1;
            try {
                pageId = Integer.parseInt(request.getParameter("pageId"));
            } catch (Exception e) {
                if (request.getParameter("pageId") == null) {
                    pageId = 1;
                }
                System.out.println("pageid2: " + pageId);
            }
            int numberOfPage=0;
            
            ContestBean model=new ContestBean();
            model.setPage(pageId);
            model.getAllDataContest();
            int countRow=model.countNumberOfRowInDB();
            if(countRow==0) numberOfPage=1;
            if(countRow%5==0){
                numberOfPage=countRow/5;
                
            }else numberOfPage=countRow/5+1;
            
            request.setAttribute("INFO", model.getListContest());
            request.setAttribute("pageNumber", pageId);
            request.setAttribute("numberOfPage", numberOfPage);
            HttpSession session=request.getSession();
            session.removeAttribute("PRIZE_FOR_PROVIDE");
            session.removeAttribute("LIST_USER");
            session.removeAttribute("LIST_RANK");
            session.removeAttribute("cartt");
            
            
        } catch (Exception e) {
            
            log("ERROR at LoadDataContestController: "+e.getMessage());
        }finally{
            request.getRequestDispatcher(PageLinkConstants.CONTESTMANAGER).forward(request, response);
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
