/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thanh.beans.UserBean;
import thanh.consts.PageLinkConstants;
import thanh.dtos.UserDTO;
import thanh.dtos.UserErrorObj;

/**
 *
 * @author Short Corn
 */
public class InsertUserController extends HttpServlet {

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
        String username = null;
        UserErrorObj errorObj = null;
        try {
            errorObj=new UserErrorObj();
            boolean valid=true;
            username=request.getParameter("txtUsername");
            String password=request.getParameter("txtPassword");
            String email=request.getParameter("txtEmail");
            String phone=request.getParameter("txtPhone");
            String address=request.getParameter("txtAddress");
            
            
    
            
            String birthDate = request.getParameter("txtBirthDate");
            
            if(birthDate.length()!=0){
                try {
                    System.out.println(birthDate);
                    String[] year=birthDate.split("-");
                    System.out.println("year2: "+year[0]);
                    int validYear=Integer.parseInt(year[0]);
                    System.out.println(validYear);
                    
                    if(validYear>2000) throw new Exception();
                    
                } catch (Exception e) {
                    
                    errorObj.setBirthDateError("Birthdate must be less or equal to 18 years by now");
                    valid=false;
                }
            }
            String sex=request.getParameter("txtGender");
            boolean gender;
            if(sex.equalsIgnoreCase("male")){
                gender=true;
            }else{
                gender=false;
            }
            
            
            //validate
            
            String checkEmail="\\w+@\\w+\\.\\w+";
            String checkPhone="[0-9]{10,11}";
            
            if(username.length()==0){
                errorObj.setUsernameError("Username can't be blank!");
                valid=false;
            }
            if(password.length()==0){
                errorObj.setPasswordError("Password can't be blank!");
                valid=false;
            }
            if(email.length()==0){
                errorObj.setEmailError("Email can't be blank!");
                valid=false;
            }
            else{
                if(!email.matches(checkEmail)){
                     errorObj.setEmailError("Invalid email!");
                     valid=false;
                }
            }
            
            if(phone.length()==0){
                errorObj.setPhoneNumberError("Phone can't be blank!");
                valid=false;
            }
            else{
                if(!phone.matches(checkPhone)){
                     errorObj.setPhoneNumberError("Invalid Phone!");
                     valid=false;
                }
            }
            if(address.length()==0){
                errorObj.setAddressError("Address can't be blank!");
                valid=false;
            }
            if(birthDate.length()==0){
                errorObj.setBirthDateError("Birthdate can't be blank!");
                valid=false;
            }
            if(valid){
                
                UserDTO dto=new UserDTO(username, password, email, phone, address, phone, birthDate, gender);
            
                UserBean bean=new UserBean();
                bean.setDto(dto);
                boolean check=bean.insertUser();
                
                if(check){
                    HttpSession session=request.getSession();
                    session.setAttribute("CURRENT_USER", dto.getUsername());
                    url="LoadIndexDataController";
                    session.removeAttribute("CURRENT_ROLE");
                    
                }else{
                    request.setAttribute("ERROR", "insert failed");
                }
            }else{
                request.setAttribute("INVALID", errorObj);
                url="registrationForm.jsp";
               
            }
             
        } catch (Exception e) {
            
            log("ERROR at InsertUserController: "+e.getMessage());
            if(e.getMessage().contains("Violation of PRIMARY KEY constraint")){
                errorObj.setUsernameError("Account "+username+" has been existed");
                request.setAttribute("INVALID", errorObj);
                url="registrationForm.jsp";
                System.out.println(errorObj.getUsernameError());
            }
            if(e.getMessage().contains("Violation of UNIQUE KEY constraint") && e.getMessage().contains("@") ){
                errorObj.setEmailError("This email has been existed");
                request.setAttribute("INVALID", errorObj);
                url="registrationForm.jsp";
                System.out.println(errorObj.getEmailError());
            }
            if(e.getMessage().contains("Violation of UNIQUE KEY constraint") && !e.getMessage().contains("@") ){
                errorObj.setPhoneNumberError("This number has been existed");
                request.setAttribute("INVALID", errorObj);
                url="registrationForm.jsp";
                System.out.println(errorObj.getPhoneNumberError());
            }
            
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
