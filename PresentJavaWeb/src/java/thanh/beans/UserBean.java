/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.beans;

import java.io.Serializable;
import java.util.List;
import thanh.daos.UserDAO;
import thanh.dtos.UserDTO;

/**
 *
 * @author Short Corn
 */
public class UserBean implements Serializable{
    UserDTO dto;
    List<UserDTO> listUser;
    String username;
    int page, numberOfPage;
    
    public UserBean() {
    }

    public List<UserDTO> getListUser() {
        return listUser;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setListUser(List<UserDTO> listUser) {
        this.listUser = listUser;
    }

    public UserDTO getDto() {
        return dto;
    }

    public void setDto(UserDTO dto) {
        this.dto = dto;
    }
    public boolean insertUser()throws Exception{
        UserDAO dao=new UserDAO();
        return dao.insertUser(dto);
    }
    public void getAllDataUser()throws Exception{
        UserDAO dao=new UserDAO();
        listUser=dao.getAllDataUser(page);
    }
    public boolean updateUser()throws Exception{
        UserDAO dao=new UserDAO();
        return dao.updateUser(dto);
    }
    public boolean deleteUser()throws Exception{
        UserDAO dao=new UserDAO();
        return dao.deleteUser(username);
    }
    public void findUserByLikeUsername()throws Exception{
        UserDAO dao=new UserDAO();
        listUser=dao.findByLikeUsername(username);
    }
    public void findUserByPrimaryKey()throws Exception{
        UserDAO dao=new UserDAO();
        dto=dao.findUserByPrimaryKey(username);
    }
    public int countNumberOfRowInDB()throws Exception{
        UserDAO dao=new UserDAO();
        return numberOfPage=dao.countNumberOfRowInDB();
    }
}
