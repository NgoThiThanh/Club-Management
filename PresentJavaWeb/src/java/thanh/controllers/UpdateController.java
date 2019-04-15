/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thanh.beans.ContestBean;
import thanh.consts.PageLinkConstants;
import thanh.dtos.ContestDTO;

/**
 *
 * @author Short Corn
 */
public class UpdateController extends HttpServlet {

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
            String action=request.getParameter("action");
            System.out.println("action trong updateC: "+action);
            if(action.equalsIgnoreCase("edit")){
                String contestID=request.getParameter("txtContestID");
                ContestBean bean=new ContestBean();
                bean.setContestId(contestID);
                bean.findContestByPrimaryKey();
                request.setAttribute("DTO", bean.getDto());
                url=PageLinkConstants.EDITCONTEST;
            }else if(action.equalsIgnoreCase("update")){
                String contestID=request.getParameter("txtContestId");
                String contestName=request.getParameter("txtContestName");
                String address=request.getParameter("txtContestAddress");
                

                String timeEndReg=request.getParameter("txtEndRegis");
                String[] fullTimeEndReg=timeEndReg.split("T");
                String fTime=fullTimeEndReg[0];
                System.out.println("t1"+fTime);
                String lTime=fullTimeEndReg[1];
                System.out.println("t2"+lTime);
                String okTime=fTime+" "+lTime+":00";
                System.out.println("time "+okTime);
                Timestamp endRegis=Timestamp.valueOf(okTime);
                System.out.println("endR: "+endRegis);

                String startDate=request.getParameter("txtStartDate");
                String[] fullStartDate=startDate.split("T");
                String fTime2=fullStartDate[0];
                System.out.println("t1"+fTime);
                String lTime2=fullStartDate[1];
                System.out.println("t2"+lTime);
                String okTime2=fTime2+" "+lTime2+":00";
                System.out.println("time "+okTime2);
                Timestamp okStartDate=Timestamp.valueOf(okTime2);
                System.out.println("endR: "+okStartDate);

                String endDate=request.getParameter("txtEndDate");
                String[] fullEndDate=endDate.split("T");
                String fTime3=fullEndDate[0];
                System.out.println("t1"+fTime);
                String lTime3=fullEndDate[1];
                System.out.println("t2"+lTime);
                String okTime3=fTime3+" "+lTime3+":00";
                System.out.println("time "+okTime3);
                Timestamp okEndDate=Timestamp.valueOf(okTime3);
                System.out.println("endR: "+okEndDate);



                
                String status=request.getParameter("txtStatus");
                String description=request.getParameter("txtDes");
                ContestDTO dto=new ContestDTO(contestID, contestName, address, status, description, okStartDate, endRegis, okStartDate, okEndDate);

                ContestBean bean=new ContestBean();
                bean.setDto(dto);
                boolean check=bean.updateContest();
                System.out.println(check);
              
                if(check){
                    url=PageLinkConstants.LOADCONTEST;
                
                }else{
                    request.setAttribute("ERROR", "update failed");
                }
                }else{
                    request.setAttribute("ERROR", "Action is not supported");
                }
        } catch (Exception e) {
            
            log("ERROR at UpdateController: "+e.getMessage());
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
