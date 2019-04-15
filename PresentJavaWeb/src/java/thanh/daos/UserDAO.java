/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import thanh.conn.MyConnection;
import thanh.dtos.ContestDTO;
import thanh.dtos.UserDTO;

/**
 *
 * @author Short Corn
 */
public class UserDAO {
    Connection conn;
    PreparedStatement pre;
    ResultSet rs;
    
    private void closeConnection()throws Exception{
        if(rs!=null)rs.close();
        if(pre!=null)pre.close();
        if(conn!=null)conn.close();
    }
    
    public String checkLoginByEmailOrPhone(String emailOrPhone, String password)throws Exception{
        String role="failed";
        try{
            conn=MyConnection.getMyConnection();
            String sql="select role from Users where email=? and password=? or phone=? and password=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, emailOrPhone);
            pre.setString(2, password);
            pre.setString(3, emailOrPhone);
            pre.setString(4, password);
            rs=pre.executeQuery();
            if(rs.next())
                role=rs.getString("Role");
        }finally{
            closeConnection();
        }
        return role;
    }
    
    public String getCurrentUserByEmailOrPhone(String emailOrPhone)throws Exception{
        String username="";
        try {
            conn=MyConnection.getMyConnection();
            String sql="select username from Users where email=? or phone =?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, emailOrPhone);
            pre.setString(2, emailOrPhone);
            rs=pre.executeQuery();
            if(rs.next()){
                username=rs.getString("username");
            }
        } finally{
            closeConnection();
        }
        return username;
    }
    
    //form dang ki
    public boolean insertUser(UserDTO dto)throws Exception{
        boolean check=false;
        
        try {
            conn=MyConnection.getMyConnection();
            String sql="insert into Users(username,password, email,phone, address,birthDate,gender,role) values(?,?,?,?,?,?,?,?)";
            pre=conn.prepareStatement(sql);
            pre.setString(1, dto.getUsername());
            pre.setString(2, dto.getPassword());
            pre.setString(3, dto.getEmail());
            pre.setString(4, dto.getPhone());
            pre.setString(5, dto.getAddress());
            pre.setString(6, dto.getBirthDate());
            pre.setBoolean(7, dto.isGender());
            pre.setString(8, "user");
           
            int i=pre.executeUpdate();
            if(i>0) check=true;
        } finally{
            closeConnection();
        }
        return check;
    }
    public boolean updateUser(UserDTO dto)throws Exception{
        boolean check=false;
        try{
            conn=MyConnection.getMyConnection();
            String sql="update users set password=?, email=?,phone=?, address=?,birthDate=?,gender=?, role=? where username=?";
            pre=conn.prepareStatement(sql);
            
            pre.setString(1, dto.getPassword());
            pre.setString(2, dto.getEmail());
            pre.setString(3, dto.getPhone());
            pre.setString(4, dto.getAddress());
            pre.setString(5, dto.getBirthDate());
            pre.setBoolean(6, dto.isGender());
            pre.setString(7, dto.getRole());
            pre.setString(8, dto.getUsername());
            int i=pre.executeUpdate();
            if(i>0) check=true;
        }finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteUser(String username)throws Exception{
        boolean check=false;
        try{
            conn=MyConnection.getMyConnection();
            String sql="delete from Users where username=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, username);
            int i=pre.executeUpdate();
            if(i>0) check=true;
        }finally{
            closeConnection();
        }
        return check;
    }
    //load all data to table
    public List<UserDTO> getAllDataUser(int page)throws Exception{
        List<UserDTO> result=new ArrayList<>();
        UserDTO dto=null;
        String username, email,phone, address, role, birthDate;
         boolean gender;
        try {
            conn=MyConnection.getMyConnection();
            String sql="select top (5) username, email,phone, address,birthDate,gender, role from Users where username not in (select top " + (page * 5 - 5) + " username from USERS )";
            pre=conn.prepareStatement(sql);
            rs=pre.executeQuery();
            while(rs.next()){
                username=rs.getString("username");
                email=rs.getString("email");
                phone=rs.getString("phone");
                address=rs.getString("address");
                birthDate=rs.getString("birthDate");
                gender=rs.getBoolean("gender");
                role=rs.getString("role");
                dto=new UserDTO(username, phone, email, phone, address, role, birthDate, gender);
                result.add(dto);
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    public List<UserDTO> findByLikeUsername(String search)throws Exception{
        List<UserDTO> result=new ArrayList<>();
        UserDTO dto=null;
        String username, email,phone, address, role, birthDate;
         boolean gender;
        try {
            conn=MyConnection.getMyConnection();
            String sql="select username, email,phone, address,birthDate,gender, role from Users where username like ? ";
            pre=conn.prepareStatement(sql);
            pre.setString(1, "%"+search+"%");
            rs=pre.executeQuery();
            while(rs.next()){
                username=rs.getString("username");
                email=rs.getString("email");
                phone=rs.getString("phone");
                address=rs.getString("address");
                birthDate=rs.getString("birthDate");
                gender=rs.getBoolean("gender");
                role=rs.getString("role");
                dto=new UserDTO(username, phone, email, phone, address, role, birthDate, gender);
                result.add(dto);
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    
    public UserDTO findUserByPrimaryKey(String id)throws Exception{
        
        UserDTO dto=null;
        String username, email,phone, address, role, birthDate;
         boolean gender;
        try {
            conn=MyConnection.getMyConnection();
            String sql="select username, email,phone, address,birthDate,gender, role from Users where username = ? ";
            pre=conn.prepareStatement(sql);
            pre.setString(1, id);
            rs=pre.executeQuery();
            if(rs.next()){
                username=rs.getString("username");
                email=rs.getString("email");
                phone=rs.getString("phone");
                address=rs.getString("address");
                birthDate=rs.getString("birthDate");
                gender=rs.getBoolean("gender");
                role=rs.getString("role");
                dto=new UserDTO(username, phone, email, phone, address, role, birthDate, gender);
                
            }
        } finally{
            closeConnection();
        }
        return dto;
    }
    
    //count number of row in contest
     public int countNumberOfRowInDB() throws Exception{
        int count = 0;
        try {
            
            conn=MyConnection.getMyConnection();
            String sql = "Select count(*) from USERS";
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
