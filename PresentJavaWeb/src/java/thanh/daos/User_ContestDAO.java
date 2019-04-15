/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import thanh.conn.MyConnection;
import thanh.dtos.User_ContestDTO;

/**
 *
 * @author Short Corn
 */
public class User_ContestDAO implements Serializable{
    Connection conn;
    PreparedStatement pre;
    ResultSet rs;

    public User_ContestDAO() {
    }
    
    private void closeConnection()throws Exception{
        if(rs!=null)rs.close();
        if(pre!=null) pre.close();
        if(conn!=null) conn.close();
    }
    
    //insert username, contestid , rank=none wwhen user regist contest
    public boolean insertUserAndContest(User_ContestDTO dto)throws Exception{
        boolean check=true;
        try {
            conn=MyConnection.getMyConnection();
            String sql="insert into User_Contest(username, contestId, rank) values(?,?,?)";
            pre=conn.prepareStatement(sql);
            pre.setString(1, dto.getUsername());
            pre.setString(2, dto.getContestId());
            pre.setString(3, dto.getRank());
            check=pre.executeUpdate()>0;
            
        } finally{
            closeConnection();
        }
        return check;
    }
    
    //load all contests, which user has been registed
    public List<User_ContestDTO> loadRegistedContest(String username)throws Exception{
        List<User_ContestDTO> result=new ArrayList<>();
        User_ContestDTO dto=null;
        String contestId;
        try{
            conn=MyConnection.getMyConnection();
            String sql="select ContestId from User_Contest where username=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, username);
            rs=pre.executeQuery();
            while(rs.next()){
                contestId=rs.getString("ContestId");
                dto=new User_ContestDTO();
                dto.setContestId(contestId);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    
    //load all user of a contest
    public List<User_ContestDTO> loadUserOfContest(String contestID)throws Exception{
        List<User_ContestDTO> result=new ArrayList<>();
        User_ContestDTO dto=null;
        String username, contestId;
        try{
            conn=MyConnection.getMyConnection();
            String sql="select username, contestId from user_Contest where contestId=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, contestID);
            rs=pre.executeQuery();
            while(rs.next()){
                username=rs.getString("username");
                contestId=rs.getString("contestId");
                dto=new User_ContestDTO(username, contestId);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    //cap nhat rank (save)
    
    public boolean applyRankForUser(User_ContestDTO dto)throws Exception{
        boolean check=false;
        try{
            conn=MyConnection.getMyConnection();
            String sql="update User_Contest set rank=? where contestId=? and username=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, dto.getRank());
            pre.setString(2, dto.getContestId());
            pre.setString(3, dto.getUsername());
            check=pre.executeUpdate()>0;
            
        }finally{
            closeConnection();
        }
        return check;
    }
    //set tat ca rank=none roi cap nhat lai
    public boolean makeRankNone(String contestId)throws Exception{
        boolean check=false;
        try{
            conn=MyConnection.getMyConnection();
            String sql="update User_Contest set rank=? where contestId=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, "None");
            pre.setString(2, contestId);
            
            check=pre.executeUpdate()>0;
            
        }finally{
            closeConnection();
        }
        return check;
    }
    
    //cong bo giai, load rank
    public List<User_ContestDTO> loadRankAndUser(String contestId)throws Exception{
        List<User_ContestDTO> result=new ArrayList<>();
        User_ContestDTO dto=null;
        String username, rank;
        try{
            conn=MyConnection.getMyConnection();
            String sql="select username, rank from User_Contest where ContestId=? and rank=? or ContestId=? and rank=? or ContestId=? and rank=? ORDER BY rank asc";
            pre=conn.prepareStatement(sql);
            pre.setString(1, contestId);
            pre.setString(2, "1");
            pre.setString(3, contestId);
            pre.setString(4, "2");
            pre.setString(5, contestId);
            pre.setString(6, "3");
            rs=pre.executeQuery();
            while(rs.next()){
                username=rs.getString("username");
                rank=rs.getString("rank");
                dto=new User_ContestDTO();
                dto.setUsername(username);
                dto.setRank(rank);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    
    //delete by contestId khi xoa trong bang contest
    
    public boolean deleteByContestId(String contestId)throws Exception{
        boolean check=false;
        try{
            conn=MyConnection.getMyConnection();
            String sql="delete from User_Contest where contestId=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, contestId);
            check=pre.executeUpdate()>0;
            
        }finally{
            closeConnection();
        }
        return check;
    }
    //delete by username khi xoa bang user
    public boolean deleteByUsername(String username)throws Exception{
        boolean check=false;
        try{
            conn=MyConnection.getMyConnection();
            String sql="delete from User_Contest where username=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, username);
            check=pre.executeUpdate()>0;
            
        }finally{
            closeConnection();
        }
        return check;
    }
}
