/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.dtos;

import java.io.Serializable;

/**
 *
 * @author Short Corn
 */
public class UserErrorObj implements Serializable{
    String emailOrPhoneError, passwordError, birthDateError, emailError, phoneNumberError, addressError, usernameError, roleError;

    public UserErrorObj() {
    }

    public String getRoleError() {
        return roleError;
    }

    public void setRoleError(String roleError) {
        this.roleError = roleError;
    }

    public String getBirthDateError() {
        return birthDateError;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

   

    public void setBirthDateError(String birthDateError) {
        this.birthDateError = birthDateError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPhoneNumberError() {
        return phoneNumberError;
    }

    public void setPhoneNumberError(String phoneNumberError) {
        this.phoneNumberError = phoneNumberError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getEmailOrPhoneError() {
        return emailOrPhoneError;
    }

    public void setEmailOrPhoneError(String emailOrPhoneError) {
        this.emailOrPhoneError = emailOrPhoneError;
    }

 
   
    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }
    
}
