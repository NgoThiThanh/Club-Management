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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import thanh.conn.MyConnection;
import thanh.dtos.ContestDTO;

/**
 *
 * @author Short Corn
 */
public class ContestDAO implements Serializable{
    Connection conn;
    PreparedStatement pre;
    ResultSet rs;

    public ContestDAO() {
    }
    
    private void closeConnection()throws Exception{
        if(rs!=null)rs.close();
        if(pre!=null) pre.close();
        if(conn!=null) conn.close();
    }
    
    //load all data contest to table 
    public List<ContestDTO> getAllDataContest(int page)throws Exception{
        List<ContestDTO> result=new ArrayList<>();
        ContestDTO dto=null;
        String contestID, contestName, contestAddress, status;
        Timestamp startDate,endDate;

        try {
            conn=MyConnection.getMyConnection();
            String sql="select top (5) contestID,contestName, contestAddress, startDate, endDate, status from CONTEST where contestId not in (select top " + (page * 5 - 5) + " contestId from CONTEST )";
            pre=conn.prepareStatement(sql);
            rs=pre.executeQuery();
            while(rs.next()){
                contestID=rs.getString("contestID");
                contestName=rs.getString("contestName");
                contestAddress=rs.getString("contestAddress");
                startDate=rs.getTimestamp("startDate");
                endDate=rs.getTimestamp("endDate");
                
                status=rs.getString("status");
                dto=new ContestDTO(contestID, contestName, contestAddress, status, startDate, endDate);
                result.add(dto);
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    
    //delete by contest ID
    public boolean deleteContest(String contestID)throws Exception{
        boolean check=false;
        try{
            conn=MyConnection.getMyConnection();
            String sql="delete from Contest where contestId=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, contestID);
            int i=pre.executeUpdate();
            if(i>0) check=true;
        }finally{
            closeConnection();
        }
        return check;
    }
    
    //find contest from date to date
    public List<ContestDTO> findContestByDate(String fromDate, String toDate)throws Exception{
        List<ContestDTO> result=new ArrayList<>();
        ContestDTO dto=null;
        String contestID, contestName, contestAddress, status;
        Timestamp startDate,endDate;

        try{
            conn=MyConnection.getMyConnection();
            String sql="select contestID,contestName, contestAddress, startDate, endDate, status from CONTEST where startDate>=? and startDate<=? ";
            pre=conn.prepareStatement(sql);
            pre.setString(1, fromDate);
            pre.setString(2, toDate);
            rs=pre.executeQuery();
            while(rs.next()){
                contestID=rs.getString("contestID");
                contestName=rs.getString("contestName");
                contestAddress=rs.getString("contestAddress");
                startDate=rs.getTimestamp("startDate");
                endDate=rs.getTimestamp("endDate");

                status=rs.getString("status");
                dto=new ContestDTO(contestID, contestName, contestAddress, status, startDate, endDate);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    
    public boolean insertContest(ContestDTO dto)throws Exception{
        boolean check=false;
        try {
            conn=MyConnection.getMyConnection();
            String sql="insert into Contest (contestID,contestName,contestAddress,status,description,startDateRegistration,endDateRegistration,startDate,endDate)  values (?,?,?,?,?,?,?,?,?)";
            pre=conn.prepareStatement(sql);
            pre.setString(1, dto.getContestID());
            pre.setString(2, dto.getContestName());
            pre.setString(3, dto.getContestAddress());
            pre.setString(4, dto.getStatus());
            pre.setString(5, dto.getDescription());
            pre.setTimestamp(6, dto.getStartDateRegistration());
            pre.setTimestamp(7, dto.getEndDateRegistration());
            pre.setTimestamp(8, dto.getStartDate());
            pre.setTimestamp(9, dto.getEndDate());
            
            int i=pre.executeUpdate();
            if(i>0) check=true;
        }finally{
            closeConnection();
        }
        return check;
    }
    
    public ContestDTO findContestByPrimaryKey(String contestId)throws Exception{
        ContestDTO dto=null;
        String contestID, contestName, contestAddress, status, description;
        Timestamp startDateRegistration,endDateRegistration,startDate,endDate;

        try{
            conn=MyConnection.getMyConnection();
            String sql="select contestID,contestName,contestAddress,status,description,startDateRegistration,endDateRegistration,startDate,endDate from Contest where contestId=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, contestId);
            rs=pre.executeQuery();
            if(rs.next()){
                contestID=rs.getString("contestID");
                contestName=rs.getString("contestName");
                contestAddress=rs.getString("contestAddress");
                status=rs.getString("status");
                description=rs.getString("description");
                startDateRegistration=rs.getTimestamp("startDateRegistration");
                endDateRegistration=rs.getTimestamp("endDateRegistration");
                startDate=rs.getTimestamp("startDate");
                endDate=rs.getTimestamp("endDate");
                
                dto=new ContestDTO(contestID, contestName, contestAddress, status, description, startDateRegistration, endDateRegistration, startDate, endDate);
            }
        }finally{
            closeConnection();
        }
        return dto;
    }
    
    public boolean updateContest(ContestDTO dto)throws Exception{
        boolean check=false;
        try{
            conn=MyConnection.getMyConnection();
            String sql="update Contest set contestName=?,contestAddress=?,status=?,description=?,endDateRegistration=?,startDate=?,endDate=? from Contest where contestId=?";
            pre=conn.prepareStatement(sql);
            
            pre.setString(1, dto.getContestName());
            pre.setString(2, dto.getContestAddress());
            pre.setString(3, dto.getStatus());
            pre.setString(4, dto.getDescription());
            pre.setTimestamp(5, dto.getEndDateRegistration());
            pre.setTimestamp(6, dto.getStartDate());
            pre.setTimestamp(7, dto.getEndDate());
           
            pre.setString(8, dto.getContestID());
            int i=pre.executeUpdate();
            if(i>0) check=true;
            
        }finally{
            closeConnection();
        }
            return check;
    }
    
    //load all contest not start for user to regis
    public List<ContestDTO> loadContestForRegis(String stt)throws Exception{
        List<ContestDTO> result=new ArrayList<>();
        ContestDTO dto=null;
        String contestID, contestName, description;
        Timestamp  startDateRegistration,endDateRegistration,startDate,endDate;

        try{
            conn=MyConnection.getMyConnection();
            String sql="select contestID,contestName,description,startDateRegistration,endDateRegistration,startDate,endDate from Contest where status=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, stt);
            rs=pre.executeQuery();
            while(rs.next()){
                contestID=rs.getString("contestID");
                contestName=rs.getString("contestName");
                description=rs.getString("description");
                startDateRegistration=rs.getTimestamp("startDateRegistration");
                endDateRegistration=rs.getTimestamp("endDateRegistration");
                startDate=rs.getTimestamp("startDate");
                endDate=rs.getTimestamp("endDate");

                dto=new ContestDTO(contestID, contestName, description, startDateRegistration, endDateRegistration, startDate, endDate);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    
    //count number of row in contest
     public int countNumberOfRowInDB() throws Exception{
        int count = 0;
        try {
            
            conn=MyConnection.getMyConnection();
            String sql = "Select count(*) from CONTEST";
            pre=conn.prepareStatement(sql);
            rs=pre.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            
        }
        finally{
            closeConnection();
        }
        return count;
    }
    
    
}
