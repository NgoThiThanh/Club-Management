/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thanh.beans.ContestBean;
import thanh.beans.ContestInfoBean;
import thanh.beans.PrizeBean;
import thanh.beans.User_ContestBean;
import thanh.dtos.ContestDTO;
import thanh.dtos.ContestInfoDTO;
import thanh.dtos.User_ContestDTO;

/**
 *
 * @author Short Corn
 */
public class loadDataContestInfoController extends HttpServlet {

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
            //mo ta
            String contestId=request.getParameter("txtContestId");

            ContestBean model1=new ContestBean();
            model1.setContestId(contestId);
            ContestDTO dto=model1.findContestByPrimaryKey();

            request.setAttribute("CONTEST_DTO", dto);
          
            //phan thuong
            
            
            PrizeBean modelPrize=new PrizeBean();
            String prizeName;
            ContestInfoBean model2=new ContestInfoBean();
            model2.setContestId(contestId);
            List<ContestInfoDTO> result2=model2.loadDataContestInfoByPrimarykey();
            
            for (ContestInfoDTO contestInfoDTO : result2) {
                //ten prize
                modelPrize.setPriceID(contestInfoDTO.getPrizeId());
                prizeName=modelPrize.loadPrizeNameById();
                
                contestInfoDTO.setPrizeName(prizeName);
                
            }
            request.setAttribute("INFO", result2);
            
           
            
            //nhan thuong
            User_ContestBean model3=new User_ContestBean();
            model3.setContestId(contestId);
            List<User_ContestDTO> result3=model3.loadRankAndUser();
            request.setAttribute("USER_RANK", result3);
            for (User_ContestDTO user_ContestDTO : result3) {
                System.out.println("Rankhuhu:"+user_ContestDTO.getRank());
            }
        } catch (Exception e) {
            log("error at LoadDataContestInfoController: "+e.getMessage());
        }finally{
            request.getRequestDispatcher("ContestRegist.jsp").forward(request, response);
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
