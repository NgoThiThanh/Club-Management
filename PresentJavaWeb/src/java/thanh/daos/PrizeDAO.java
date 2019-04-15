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
import thanh.dtos.PrizeDTO;

/**
 *
 * @author Short Corn
 */
public class PrizeDAO implements Serializable{
    Connection conn;
    PreparedStatement pre;
    ResultSet rs;

    public PrizeDAO() {
    }
    
    private void closeConnection()throws Exception{
        if(rs!=null)rs.close();
        if(pre!=null) pre.close();
        if(conn!=null) conn.close();
    }
    
    //load all data prize to table 
    public List<PrizeDTO> getAllDataPrize(int page)throws Exception{
        List<PrizeDTO> result=new ArrayList<>();
        PrizeDTO dto=null;
        String prizeId, prizeName;
        int quantity;
        float price;
        try {
            conn=MyConnection.getMyConnection();
            String sql="select top (5) prizeId, prizeName ,price, quantity from Prize where prizeId not in (select top " + (page * 5 - 5) + " PrizeId from PRIZE )";
            pre=conn.prepareStatement(sql);
            rs=pre.executeQuery();
            while(rs.next()){
                prizeId=rs.getString("prizeId");
                prizeName=rs.getString("prizeName");
                price=rs.getFloat("price");
                quantity=rs.getInt("quantity");
               
              
                dto=new PrizeDTO(prizeId, prizeName, quantity, price);
                result.add(dto);
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    
    //delete by prize ID
    public boolean deletePrize(String prizeID)throws Exception{
        boolean check=false;
        try{
            conn=MyConnection.getMyConnection();
            String sql="delete from Prize where prizeId=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, prizeID);
            int i=pre.executeUpdate();
            if(i>0) check=true;
        }finally{
            closeConnection();
        }
        return check;
    }
    
    //find prize by from price to price
    public List<PrizeDTO> findPrizeByPrice(float minPrice, float maxPrice)throws Exception{
        List<PrizeDTO> result=new ArrayList<>();
        PrizeDTO dto=null;
        String prizeId, prizeName;
        int quantity;
        float price;
        try{
            conn=MyConnection.getMyConnection();
            String sql="select prizeId, prizeName ,price, quantity from Prize where price>=? and price<=?";
            pre=conn.prepareStatement(sql);
            pre.setFloat(1, minPrice);
            pre.setFloat(2, maxPrice);
            rs=pre.executeQuery();
            while(rs.next()){
                prizeId=rs.getString("prizeId");
                prizeName=rs.getString("prizeName");
                price=rs.getFloat("price");
                quantity=rs.getInt("quantity");
               
              
                dto=new PrizeDTO(prizeId, prizeName, quantity, price);
                
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    
    public boolean insertPrize(PrizeDTO dto)throws Exception{
        boolean check=false;
        try {
            conn=MyConnection.getMyConnection();
            String sql="insert into Prize (prizeId, prizeName ,price, quantity, description)  values (?,?,?,?,?)";
            pre=conn.prepareStatement(sql);
            pre.setString(1, dto.getPrizeId());
            pre.setString(2, dto.getPrizeName());
            pre.setFloat(3, dto.getPrice());
            pre.setInt(4, dto.getQuantity());

            pre.setString(5, dto.getDescription());
            
            int i=pre.executeUpdate();
            if(i>0) check=true;
        }finally{
            closeConnection();
        }
        return check;
    }
    
    public PrizeDTO findPrizeByPrimaryKey(String prizeID)throws Exception{
        PrizeDTO dto=null;
        String prizeId, prizeName, description;
        int quantity;
        float price;
        try{
            conn=MyConnection.getMyConnection();
            String sql="select prizeId, prizeName ,price, quantity, description from Prize where prizeId=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, prizeID);
            rs=pre.executeQuery();
            if(rs.next()){
                prizeId=rs.getString("prizeId");
                prizeName=rs.getString("prizeName");
                price=rs.getFloat("price");
                quantity=rs.getInt("quantity");
                description=rs.getString("Description");
                dto=new PrizeDTO(prizeId, prizeName, description, quantity, price);
            }
        }finally{
            closeConnection();
        }
        return dto;
    }
    
    public boolean updatePrize(PrizeDTO dto)throws Exception{
        boolean check=false;
        try{
            conn=MyConnection.getMyConnection();
            String sql="update Prize set prizeName=? ,price=?, quantity=?, description=? from Prize where prizeId=?";
            pre=conn.prepareStatement(sql);
            
            pre=conn.prepareStatement(sql);
            
            pre.setString(1, dto.getPrizeName());
            pre.setFloat(2, dto.getPrice());
            pre.setInt(3, dto.getQuantity());
            pre.setString(4, dto.getDescription());
            pre.setString(5, dto.getPrizeId());
            int i=pre.executeUpdate();
            if(i>0) check=true;
            
        }finally{
            closeConnection();
        }
            return check;
    }
    
    //load id,name,quantity,price by quantity>0 to load in combobox>>>add prize for contest
    public List<PrizeDTO> loadPrizeByQuantity()throws Exception{
        List<PrizeDTO> result=new ArrayList<>();
        PrizeDTO dto=null;
        String prizeId, prizeName;
        int quantity;
        float price;
        try{
            conn=MyConnection.getMyConnection();
            String sql="select PrizeId, PrizeName, price, quantity from Prize where quantity > 0";
            pre=conn.prepareStatement(sql);
            rs=pre.executeQuery();
            while(rs.next()){
                prizeId=rs.getString("PrizeId");
                prizeName=rs.getString("PrizeName");
                price=rs.getFloat("price");
                quantity=rs.getInt("quantity");
                
                dto=new PrizeDTO(prizeId, prizeName, quantity, price);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    //load id,name,quantity,price by quantity>=0 to load in combobox when saved
    public List<PrizeDTO> loadAllPrizeByQuantity()throws Exception{
        List<PrizeDTO> result=new ArrayList<>();
        PrizeDTO dto=null;
        String prizeId, prizeName;
        int quantity;
        float price;
        try{
            conn=MyConnection.getMyConnection();
            String sql="select PrizeId, PrizeName, price, quantity from Prize where quantity >= 0";
            pre=conn.prepareStatement(sql);
            rs=pre.executeQuery();
            while(rs.next()){
                prizeId=rs.getString("PrizeId");
                prizeName=rs.getString("PrizeName");
                price=rs.getFloat("price");
                quantity=rs.getInt("quantity");
                
                dto=new PrizeDTO(prizeId, prizeName, quantity, price);
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
            String sql = "Select count(*) from PRIZE";
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
     
     //load prizename by id
    public String loadPrizeNameById(String id)throws Exception{
        PrizeDTO dto=null;
        String prizeName="";
        
        try {
            conn=MyConnection.getMyConnection();
            String sql="select prizeName from prize where prizeId=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, id);
            rs=pre.executeQuery();
            if(rs.next()){
                prizeName=rs.getString("prizeName");
                
                
            }
        }finally{
            closeConnection();
        }
        return prizeName;
    }
    
}
