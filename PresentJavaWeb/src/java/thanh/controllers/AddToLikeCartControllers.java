/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thanh.beans.LikeCartObj;
import thanh.consts.PageLinkConstants;
import thanh.dtos.ContestInfoDTO;
import thanh.dtos.PrizeDTO;

/**
 *
 * @author Short Corn
 */
public class AddToLikeCartControllers extends HttpServlet {

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
            
            HttpSession session=request.getSession();
            
            LikeCartObj prizeCart = (LikeCartObj) session.getAttribute("cartt");

            String txtPrize=request.getParameter("txtPrize");
            String[] tmp=txtPrize.split("-");
            ContestInfoDTO dto=new ContestInfoDTO(tmp[0], Float.parseFloat(tmp[3]));//id, gia
            dto.setQuantity(1);
            dto.setRewardRank(1);
            dto.setQuantityInPrize(Integer.parseInt(tmp[2]));
            System.out.println("tmp2: "+Integer.parseInt(tmp[2]));
            dto.setContestId(request.getParameter("txtContestID"));
           
            if(prizeCart==null){
                prizeCart=new LikeCartObj();
            }
            
            prizeCart.addToCart(dto);
            session.setAttribute("cartt", prizeCart);
            
            
        } catch (Exception e) {
            log("error at Attolikecartcontroller: "+e.getMessage());
        }finally{
            request.getRequestDispatcher(PageLinkConstants.LOADPRIZEFORPROVIDEE).forward(request, response);
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
