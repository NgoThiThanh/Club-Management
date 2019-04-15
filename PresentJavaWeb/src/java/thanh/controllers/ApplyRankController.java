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
import thanh.beans.User_ContestBean;
import thanh.consts.PageLinkConstants;
import thanh.dtos.User_ContestDTO;

/**
 *
 * @author Short Corn
 */
public class ApplyRankController extends HttpServlet {

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
            
            String[] users=request.getParameterValues("txtUsername");
            String[] ranks=request.getParameterValues("txtRank");
            
          
            
            String contestId=request.getParameter("txtContestID");
            User_ContestDTO dto=new User_ContestDTO();
            User_ContestBean bean=new User_ContestBean();
            int count=0,test=0;
            bean.setContestId(contestId);
            bean.makeRankNone();
            for (String user : users) {
                System.out.println("user: "+user);
            }
            
            for (int j = 0; j < users.length; j++) {
                for (int k = j + 1; k < users.length; k++) {
                    if (users[j].equals(users[k])) {
                        test++;
                    }
                }
                
            }
            System.out.println("count: "+test);
            if(test>0){
                    throw new Exception("duplicated users");
            }else{
                for (String user : users) {
                    System.out.println("a?");
                    dto.setUsername(user);
                    System.out.println("user: "+user);
                    dto.setRank(ranks[count]);
                    System.out.println("rank"+ranks[count]);
                    dto.setContestId(contestId);
                        System.out.println("id: "+contestId);
                    bean.setDto(dto);
                    System.out.println("dto.id"+dto.getContestId());
                    bean.applyRankForUser();

                    count++;
                }
                url="LoadRewardAfterApplying";
            }
            
        } catch (Exception e) {
            log("error at ApplyRankController: "+e.getMessage());
            request.setAttribute("USER_DUP", e.getMessage());
            url="reward.jsp";
            
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
