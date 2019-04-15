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
import thanh.beans.PrizeBean;
import thanh.consts.PageLinkConstants;
import thanh.dtos.PrizeDTO;
import thanh.dtos.PrizeErrorDTO;

/**
 *
 * @author Short Corn
 */
public class InsertPrizeController extends HttpServlet {

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
        PrizeErrorDTO errorObj=new PrizeErrorDTO();
        String prizeId = null;
        try {
            prizeId=request.getParameter("txtPrizeId");
            String prizeName=request.getParameter("txtPrizeName");
            float price = 0;
            int quantity = 0;
            try {
                price=Float.parseFloat(request.getParameter("txtPrice"));
                quantity=Integer.parseInt(request.getParameter("txtQuantity"));
            } catch (Exception e) {
                
            }
            
            String des=request.getParameter("txtDes");
                
            
            PrizeDTO dto=new PrizeDTO(prizeId, prizeName, des, quantity, price);
            
            PrizeBean bean=new PrizeBean();
            bean.setDto(dto);
            boolean check=bean.insertPrize();
            System.out.println(check);
            if(check){
                url=PageLinkConstants.LOADPRIZEDATA;
            }else{
                request.setAttribute("ERROR", "insert failed");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("Violation of PRIMARY KEY constraint")){
                errorObj.setPrizeIdError("Prize Id "+prizeId+" has been existed");
                request.setAttribute("INVALID", errorObj);
                url="insertPrize.jsp";
                System.out.println(errorObj.getPrizeIdError());
            }
            
            log("ERROR at InsertPrizeController: "+e.getMessage());
        }
        finally{
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
