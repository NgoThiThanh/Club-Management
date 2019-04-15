/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import thanh.daos.ContestInfoDAO;
import thanh.dtos.ContestInfoDTO;

/**
 *
 * @author Short Corn
 */
public class ContestInfoBean implements Serializable{
    HashMap<String, ContestInfoDTO> listContestInfo;
    List<ContestInfoDTO> listDataContestInfo;
    String contestId,prizeId;
    List<String> listRank;
    
    public ContestInfoBean() {
    }

    public HashMap<String, ContestInfoDTO> getListContestInfo() {
        return listContestInfo;
    }

    public void setListContestInfo(HashMap<String, ContestInfoDTO> listContestInfo) {
        this.listContestInfo = listContestInfo;
    }

    public List<String> getListRank() {
        return listRank;
    }

    public void setListRank(List<String> listRank) {
        this.listRank = listRank;
    }

    public List<ContestInfoDTO> getListDataContestInfo() {
        return listDataContestInfo;
    }

    public void setListDataContestInfo(List<ContestInfoDTO> listDataContestInfo) {
        this.listDataContestInfo = listDataContestInfo;
    }

    public String getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    

    public String getContestId() {
        return contestId;
    }

    public void setContestId(String contestId) {
        this.contestId = contestId;
    }
    public HashMap<String, ContestInfoDTO> findCartByContestId()throws Exception{
        ContestInfoDAO dao=new ContestInfoDAO();
        return listContestInfo =dao.findCartByContestId(contestId);
    }
    public List<ContestInfoDTO> loadDataContestInfoByPrimarykey()throws Exception{
        ContestInfoDAO dao=new ContestInfoDAO();
        return listDataContestInfo=dao.loadDataContestInfoByPrimarykey(contestId);
    } 
    
    public boolean deleteContestInfoByContestId()throws Exception{
        ContestInfoDAO dao=new ContestInfoDAO();
        return dao.deleteContestInfoByContestId(contestId, prizeId);
    }
    public boolean deleteAllPrizeinContestInfo()throws Exception{
        ContestInfoDAO dao=new ContestInfoDAO();
        return dao.deleteAllPrizeinContestInfo(prizeId);
    }
    public List<String> getRankFromAContest()throws Exception{
        ContestInfoDAO dao=new ContestInfoDAO();
        return listRank=dao.getRankFromAContest(contestId);
    }
    public List<String> findPrizeId()throws Exception{
        ContestInfoDAO dao=new ContestInfoDAO();
        return listRank=dao.findPrizeId(contestId);
    }
}
