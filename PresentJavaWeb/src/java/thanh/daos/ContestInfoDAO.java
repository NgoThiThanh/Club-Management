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
import java.util.HashMap;
import java.util.List;
import thanh.conn.MyConnection;
import thanh.dtos.ContestInfoDTO;

/**
 *
 * @author Short Corn
 */
public class ContestInfoDAO implements Serializable{
    Connection conn;
    PreparedStatement pre;
    ResultSet rs;
    
    private void closeConnection()throws Exception{
        if(rs!=null) rs.close();
        if(pre!=null) pre.close();
        if(conn!=null) conn.close();
    }
    
    public boolean insertContestInfo(ContestInfoDTO dto) throws Exception{
        boolean check=false;
        try{
            conn=MyConnection.getMyConnection();
            String sql="insert into ContestInfo(ContestId, PrizeId,RewardRank, quantity, price) values(?,?,?,?,?)";
            pre=conn.prepareStatement(sql);
            pre.setString(1, dto.getContestId());
            pre.setString(2, dto.getPrizeId());
            pre.setInt(3, dto.getRewardRank());
            pre.setInt(4, dto.getQuantity());
            pre.setFloat(5, dto.getPrice());
            
            int i=pre.executeUpdate();
            if(i>0) check=true;
        }finally{
            closeConnection();
        }
        return check;
    }
    //load cart to session
    public HashMap<String, ContestInfoDTO> findCartByContestId(String id)throws Exception{
        HashMap<String, ContestInfoDTO> result=new HashMap<>();
        ContestInfoDTO dto=null;
        String prizeId, contestId;
        int rewardRank;
        int quantity;
        float price;
        try {
            conn=MyConnection.getMyConnection();
            String sql="select contestID, prizeID, rewardRank, quantity, price from contestInfo where contestID=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, id);
            rs=pre.executeQuery();
            while(rs.next()){
                contestId=rs.getString("contestId");
                prizeId=rs.getString("prizeId");
                rewardRank=rs.getInt("rewardRank");
                quantity=rs.getInt("quantity");
                price=rs.getFloat("price");
                
                dto=new ContestInfoDTO(prizeId, contestId, rewardRank, quantity, price);
                result.put(dto.getPrizeId(), dto);
            }
                    
        } finally{
            closeConnection();
        }
        return result;
    }
    //load for user to regist
    public List<ContestInfoDTO> loadDataContestInfoByPrimarykey(String id)throws Exception{
        List<ContestInfoDTO> result=new ArrayList<>();
        ContestInfoDTO dto=null;
        String prizeId, contestId;
        int rewardRank;
        int quantity;
        float price;
        try {
            conn=MyConnection.getMyConnection();
            String sql="select contestID, prizeID, rewardRank, quantity, price from contestInfo where contestID=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, id);
            rs=pre.executeQuery();
            while(rs.next()){
                contestId=rs.getString("contestId");
                prizeId=rs.getString("prizeId");
                rewardRank=rs.getInt("rewardRank");
                quantity=rs.getInt("quantity");
                price=rs.getFloat("price");
                
                dto=new ContestInfoDTO(prizeId, contestId, rewardRank, quantity, price);
                result.add(dto);
            }
                    
        } finally{
            closeConnection();
        }
        return result;
    }
    
    //lay id prize, de xóa từng dòng
    public List<String> findPrizeId(String cId)throws Exception{
        List<String> result=new ArrayList<>();
        String prizeId;
        try{
            conn=MyConnection.getMyConnection();
            String sql="select prizeId from ContestInfo where contestId =?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, cId);
            rs=pre.executeQuery();
            while(rs.next()){
                prizeId=rs.getString("prizeId");
                result.add(prizeId);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    //delete cart by contestid, prizeid de xoa tung dong
    public boolean deleteContestInfoByContestId(String cId,String pId)throws Exception{
        boolean check=false;
        try{
            conn=MyConnection.getMyConnection();
            String sql="delete from ContestInfo where contestId=? and prizeId=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1, cId);
            pre.setString(2, pId);
            check=pre.executeUpdate()>0;
        }finally{
            closeConnection();
        }
        return check;
        
    }
    

    
    //load rank which have in a specific contest
    public List<String> getRankFromAContest(String idContest)throws Exception{
        List<String> result=new ArrayList<>();
        try {
            conn=MyConnection.getMyConnection();
            String sql="select rewardRank from contestinfo where ContestId=? ORDER BY rewardRank asc";
            pre=conn.prepareStatement(sql);
            pre.setString(1, idContest);
            rs=pre.executeQuery();
            while(rs.next()){
                result.add(rs.getString("rewardRank"));
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    //xoa tat ca prize ton tai trong contestinfo khi xoa bang chinh prize
   public boolean deleteAllPrizeinContestInfo(String prizeId)throws Exception{
       boolean check=false;
       try{
           conn=MyConnection.getMyConnection();
           String sql="delete from ContestInfo where prizeId =?";
           pre=conn.prepareStatement(sql);
           pre.setString(1, prizeId);
           check=pre.executeUpdate()>0;
       }finally{
           closeConnection();
       }
       return check;
   }

}
