/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.beans;

import java.io.Serializable;
import java.util.List;
import thanh.daos.User_ContestDAO;
import thanh.dtos.User_ContestDTO;

/**
 *
 * @author Short Corn
 */
public class User_ContestBean implements Serializable{
    User_ContestDTO dto; 
    String username, contestId;
    List<User_ContestDTO> listUserContest;

    public User_ContestBean() {
    }

    public List<User_ContestDTO> getListUserContest() {
        return listUserContest;
    }

    public void setListUserContest(List<User_ContestDTO> listUserContest) {
        this.listUserContest = listUserContest;
    }

    public User_ContestDTO getDto() {
        return dto;
    }

    public void setDto(User_ContestDTO dto) {
        this.dto = dto;
    }

    public String getContestId() {
        return contestId;
    }

    public void setContestId(String contestId) {
        this.contestId = contestId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public boolean insertUserAndContest()throws Exception{
        User_ContestDAO dao=new User_ContestDAO();
        return dao.insertUserAndContest(dto);
    }
    public List<User_ContestDTO> loadRegistedContest()throws Exception{
        User_ContestDAO dao=new User_ContestDAO();
        return listUserContest=dao.loadRegistedContest(username);
    }
    public List<User_ContestDTO> loadUserOfContest()throws Exception{
        User_ContestDAO dao=new User_ContestDAO();
        return listUserContest=dao.loadUserOfContest(contestId);
    }
    
    public boolean applyRankForUser()throws Exception{
         User_ContestDAO dao=new User_ContestDAO();
         return dao.applyRankForUser(dto);
    }
    public boolean makeRankNone()throws Exception{
         User_ContestDAO dao=new User_ContestDAO();
         return dao.makeRankNone(contestId);
    }
    public List<User_ContestDTO> loadRankAndUser()throws Exception{
        User_ContestDAO dao=new User_ContestDAO();
        return listUserContest=dao.loadRankAndUser(contestId);
    }
    public boolean deleteByUsername()throws Exception{
        User_ContestDAO dao=new User_ContestDAO();
        return dao.deleteByUsername(username);
    }
    public boolean deleteByContestId()throws Exception{
        User_ContestDAO dao=new User_ContestDAO();
        return dao.deleteByContestId(contestId);
    }
}
