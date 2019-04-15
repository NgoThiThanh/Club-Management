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
import javax.servlet.http.HttpSession;
import thanh.beans.AccountBean;
import thanh.consts.PageLinkConstants;
import thanh.dtos.UserErrorObj;

/**
 *
 * @author Short Corn
 */
public class LoginController extends HttpServlet {

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
            String emailOrPhone=request.getParameter("txtEmailOrPhone");
            String password=request.getParameter("txtPassword");
            //validate
            UserErrorObj errorObj=new UserErrorObj();
            boolean valid=true;
            String checkEmail="\\w+@\\w+\\.\\w+";
            String checkPhone="[0-9]{10,11}";
            if(emailOrPhone.length()==0){
                errorObj.setEmailOrPhoneError("Email or Phone can't be blank!");
                valid=false;
            }
            if(password.length()==0){
                errorObj.setPasswordError("Password can't be blank!");
                valid=false;
            }
            if(emailOrPhone.length()!=0){
                if(!emailOrPhone.matches(checkEmail) && !emailOrPhone.matches(checkPhone)){
                     errorObj.setEmailOrPhoneError("Invalid email or phone!");
                     valid=false;
                }
            }
            
            
            if(valid){
                AccountBean model=new AccountBean();
                model.setEmailOrPhone(emailOrPhone);
                model.setPassword(password);

                String role=model.checkLoginByEmailOrPhone();
                System.out.println("role: "+role);
                if(role.equalsIgnoreCase("failed")){
                    request.setAttribute("ERROR", "Invalid username or password");
                }else{

                    HttpSession session=request.getSession();
                    session.setAttribute("CURRENT_USER", model.getCurrentUserByEmailOrPhone());
                    session.setAttribute("CURRENT_ROLE", role);
                    
                    if(role.equalsIgnoreCase("admin")){
                        url=PageLinkConstants.ADMIN;
                        
                    }else if(role.equalsIgnoreCase("user")){
                        url="LoadIndexDataController";
                    }else{
                        request.setAttribute("ERROR", "Your role is not valid");
                    }
                    
                }
            }else{
                request.setAttribute("INVALID", errorObj);
                url="login.jsp";
            }
        } catch (Exception e) {
            log("ERROR at LoginController: "+e.getMessage());
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
