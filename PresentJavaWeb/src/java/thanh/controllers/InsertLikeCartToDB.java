/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.controllers;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thanh.beans.ContestInfoBean;
import thanh.beans.LikeCartObj;
import thanh.daos.ContestInfoDAO;
import thanh.dtos.ContestInfoDTO;

/**
 *
 * @author Short Corn
 */
public class InsertLikeCartToDB extends HttpServlet {

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
            
            
            String contestId=request.getParameter("txtContestID");
            System.out.println("contestId: "+contestId);
            ContestInfoBean beanInfo=new ContestInfoBean();
            beanInfo.setContestId(contestId);
            HashMap<String, ContestInfoDTO> result=beanInfo.findCartByContestId();
            HttpSession session=request.getSession();
            
            if(result.size()==0){
                //insert bt
                String[] params=request.getParameterValues("txtRank") ;
            
                int i = 0;

                
                LikeCartObj prizeCart=(LikeCartObj) session.getAttribute("cartt");
                ContestInfoDAO dao=new ContestInfoDAO();
                for (ContestInfoDTO dto : prizeCart.getCart().values()) {

                    dto.setRewardRank(Integer.valueOf(params[i++]));
                    dao.insertContestInfo(dto);

                }
            }else{
                //xoa het tung dong roi insert cart moi
                
                for (String prizeId : beanInfo.findPrizeId()) {
                    beanInfo.setPrizeId(prizeId);
                    beanInfo.deleteContestInfoByContestId();
                }
                
               
                String[] params=request.getParameterValues("txtRank") ;
            
                int i = 0;

                
                LikeCartObj prizeCart=(LikeCartObj) session.getAttribute("cartt");
                ContestInfoDAO dao=new ContestInfoDAO();
                for (ContestInfoDTO dto : prizeCart.getCart().values()) {

                    dto.setRewardRank(Integer.valueOf(params[i++]));
                    dao.insertContestInfo(dto);

                }
            }
            
            
            
            
            
        } catch (Exception e) {
            log("error at insertLikeCartToDB: "+e.getMessage());
        }finally{
            request.getRequestDispatcher("viewCart.jsp").forward(request, response);
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
