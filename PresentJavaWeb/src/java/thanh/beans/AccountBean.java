/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.beans;

import java.io.Serializable;
import thanh.daos.UserDAO;

/**
 *
 * @author Short Corn
 */
public class AccountBean implements Serializable{
    private String emailOrPhone, password;

    public AccountBean() {
    }

    public String getEmailOrPhone() {
        return emailOrPhone;
    }

    public void setEmailOrPhone(String emailOrPhone) {
        this.emailOrPhone = emailOrPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public String checkLoginByEmailOrPhone()throws Exception{
        UserDAO dao=new UserDAO();
        return dao.checkLoginByEmailOrPhone(emailOrPhone, password);
    }
    public String getCurrentUserByEmailOrPhone()throws Exception{
        UserDAO dao=new UserDAO();
        return dao.getCurrentUserByEmailOrPhone(emailOrPhone);
    }
    
}
