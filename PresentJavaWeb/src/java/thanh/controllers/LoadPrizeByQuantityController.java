/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thanh.beans.ContestInfoBean;
import thanh.beans.LikeCartObj;
import thanh.beans.PrizeBean;
import thanh.consts.PageLinkConstants;
import thanh.dtos.ContestInfoDTO;
import thanh.dtos.PrizeDTO;

/**
 *
 * @author Short Corn
 */
public class LoadPrizeByQuantityController extends HttpServlet {

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
            HttpSession session=request.getSession();
            String contestId=request.getParameter("txtContestID");
            System.out.println("contestId: "+contestId);
            ContestInfoBean beanInfo=new ContestInfoBean();
            beanInfo.setContestId(contestId);
            HashMap<String, ContestInfoDTO> result=beanInfo.findCartByContestId();
            
            
            //chưa save
            if(result.size()==0){
                PrizeBean model=new PrizeBean();
                model.loadPrizeByQuantity();
                session.setAttribute("PRIZE_FOR_PROVIDE", model.getListPrize());
                request.getAttribute("TOTAL");
                url="providePrize.jsp";
                System.out.println("max quan:");
                for (int i = 0; i < model.getListPrize().size(); i++) {
                    System.out.println("huhu: "+model.getListPrize().get(i).getPrizeName());
                }
            }else{
                //da save
                PrizeBean model=new PrizeBean();
                model.loadAllPrizeByQuantity();               
                LikeCartObj  prizeCart=(LikeCartObj) session.getAttribute("cartt");

                for (int i = 0; i < model.getListPrize().size(); i++) {
                    for (ContestInfoDTO dto : result.values()) {
                        if(model.getListPrize().get(i).getPrizeId().equals(dto.getPrizeId())){
                            dto.setQuantityInPrize(model.getListPrize().get(i).getQuantity()+dto.getQuantity());
                            model.getListPrize().get(i).setGetOutQuantity(dto.getQuantity());
                            System.out.println("model:"+model.getQuantity());
                        }
                        
                    }
                }
                session.setAttribute("PRIZE_FOR_PROVIDE", model.getListPrize());
                for (PrizeDTO prizeDTO : model.getListPrize()) {
                    System.out.println("sl:"+prizeDTO.getQuantity());
                }
                if(prizeCart ==null){
                 prizeCart=new LikeCartObj();
                }
                prizeCart.setCart(result);
                session.setAttribute("cartt",prizeCart);
                
                url=PageLinkConstants.VIEWCART;
            }
            
            
            
        } catch (Exception e) {
            log("ERROR at LoadPrizeByQuantityController* "+e.getMessage());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
            System.out.println("url"+url);
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
