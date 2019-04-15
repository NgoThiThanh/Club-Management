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
import javax.servlet.http.HttpSession;
import thanh.beans.ContestInfoBean;
import thanh.beans.User_ContestBean;
import thanh.dtos.User_ContestDTO;

/**
 *
 * @author Short Corn
 */
public class RewardsControler extends HttpServlet {

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
            HttpSession session=request.getSession();
            ContestInfoBean bean1=new ContestInfoBean();
                bean1.setContestId(contestId);
                List<String> listRank=bean1.getRankFromAContest();

                for (int i = 0; i < listRank.size(); i++) {
                    for (int j = i+1; j < listRank.size(); j++) {
                         if(listRank.get(i).equalsIgnoreCase(listRank.get(j))){
                             listRank.remove(j);
                             j--;
                         }
                    }
                }
                session.setAttribute("LIST_RANK", listRank);

                //load username
                User_ContestBean bean2=new User_ContestBean();
                bean2.setContestId(contestId);
                List<User_ContestDTO> listUser=bean2.loadUserOfContest();
                session.setAttribute("LIST_USER", listUser);
                
        } catch (Exception e) {
            log("error at RewardsController: "+e.getMessage());
        }finally{
            request.getRequestDispatcher("reward.jsp").forward(request, response);
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
