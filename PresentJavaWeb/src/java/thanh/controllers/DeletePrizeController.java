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
import thanh.beans.ContestInfoBean;
import thanh.beans.PrizeBean;
import thanh.consts.PageLinkConstants;

/**
 *
 * @author Short Corn
 */
public class DeletePrizeController extends HttpServlet {

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
            String prizeId=request.getParameter("txtPrizeId");
            System.out.println("id "+prizeId);
            PrizeBean bean1=new PrizeBean();
            bean1.setPriceID(prizeId);
            ContestInfoBean bean2=new ContestInfoBean();
            bean2.setPrizeId(prizeId);
            
            bean2.deleteAllPrizeinContestInfo();
            boolean check1=bean1.deletePrize();
            
            if(check1){
                if(request.getParameter("txtMinPrice").equals("")  ||  request.getParameter("txtMaxPrice").equals("")){
                    url=PageLinkConstants.LOADPRIZEDATA;
                }else if(!request.getParameter("txtMinPrice").equals("")  &&  !request.getParameter("txtMaxPrice").equals("")){
                    url=PageLinkConstants.SEARCHPRIZE;
                }
                
            }else{
                request.setAttribute("ERROR", "Delete failed.");
            }
        } catch (Exception e) {
            log("error at deletePrizeController: "+e.getMessage());
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
