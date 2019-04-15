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
import thanh.consts.PageLinkConstants;

/**
 *
 * @author Short Corn
 */
public class MainController extends HttpServlet {

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
            System.out.println(action);
            if(action.equalsIgnoreCase("LOGIN")){
                url=PageLinkConstants.LOGIN;
            }else if(action.equalsIgnoreCase("loadContestData")){
                url=PageLinkConstants.LOADCONTEST;
            }
            else if(action.equalsIgnoreCase("delete")){
                url=PageLinkConstants.DELETECONTEST;
            }
            else if(action.equalsIgnoreCase("search")){
                url=PageLinkConstants.SEARCHBYDATE;
            }
            else if(action.equalsIgnoreCase("create")){
                url=PageLinkConstants.INSERTCONTEST;
            }
            else if(action.equalsIgnoreCase("update")||action.equalsIgnoreCase("edit")){
                url=PageLinkConstants.UPDATECONTEST;
            }
            else if(action.equalsIgnoreCase("providePrize")){
                    url=PageLinkConstants.LOADPRIZEFORPROVIDE;
            }
            else if(action.equalsIgnoreCase("providePrizee")){
                    url=PageLinkConstants.LOADPRIZEFORPROVIDEE;
            }
            else if(action.equalsIgnoreCase("provide")){
                url=PageLinkConstants.ADDTOLIKECART;
            }
            else if(action.equalsIgnoreCase("view")){
                url=PageLinkConstants.VIEWCART;
            }
            else if(action.equalsIgnoreCase("RemoveCart")){
                url=PageLinkConstants.REMOVECART;
            }
            else if(action.equalsIgnoreCase("UpdateCart")){
                url=PageLinkConstants.UPDATECART;
            }
            else if(action.equalsIgnoreCase("saveCart")){
                url=PageLinkConstants.SAVECART;
            }
            else if(action.equalsIgnoreCase("loadDataContestInfo")){
                url=PageLinkConstants.LOADDATACONTESTINFO;
            }
            else if(action.equalsIgnoreCase("reward")){
                url=PageLinkConstants.REWARD;
            }
            else{
                request.setAttribute("ERROR", "Action is not suppoted.");
            }
        } catch (Exception e) {
           
            log("ERROR at MainController: "+e.getMessage());
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
