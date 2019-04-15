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
public class User_ContestDTO implements Serializable{
    String contestId, username, rank;

    public User_ContestDTO() {
    }

    public User_ContestDTO(String username, String contestId, String rank) {
        
        this.username = username;
        this.contestId = contestId;
        this.rank = rank;
    }

    public User_ContestDTO( String username,String contestId) {
        this.username = username;
        this.contestId = contestId;
        
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    
}
