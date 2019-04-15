/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import thanh.daos.ContestDAO;
import thanh.dtos.ContestDTO;

/**
 *
 * @author Short Corn
 */
public class ContestBean implements Serializable{
    List<ContestDTO> listContest;
    String contestId;
    String fromDate, toDate, status;
    ContestDTO dto;
    int page, numberOfPage;

    public ContestDTO getDto() {
        return dto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDto(ContestDTO dto) {
        this.dto = dto;
    }

    public ContestBean() {
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    

    public String getContestId() {
        return contestId;
    }

    public void setContestId(String contestId) {
        this.contestId = contestId;
    }

    public List<ContestDTO> getListContest() {
        return listContest;
    }

    public void setListContest(List<ContestDTO> listContest) {
        this.listContest = listContest;
    }
    
    public void getAllDataContest()throws Exception{
        ContestDAO dao=new ContestDAO();
        listContest=dao.getAllDataContest(page);
        
    }
    public boolean deleteContest()throws Exception{
        ContestDAO dao=new ContestDAO();
        return dao.deleteContest(contestId);
    }
    public void findContestByDate()throws Exception{
        ContestDAO dao=new ContestDAO();
        listContest=dao.findContestByDate(fromDate, toDate);
    }
    public boolean insertContest()throws Exception{
        ContestDAO dao=new ContestDAO();
        return dao.insertContest(dto);
    }
    public ContestDTO findContestByPrimaryKey()throws Exception{
        ContestDAO dao=new ContestDAO();
        return dto= dao.findContestByPrimaryKey(contestId);
    }
    public boolean updateContest()throws Exception{
        ContestDAO dao=new ContestDAO();
        return dao.updateContest(dto);
    }
    public List<ContestDTO> loadContestForRegis() throws Exception{
        ContestDAO dao=new ContestDAO();
        return listContest=dao.loadContestForRegis(status);
    }
    public int countNumberOfRowInDB()throws Exception{
        ContestDAO dao=new ContestDAO();
        return numberOfPage=dao.countNumberOfRowInDB();
    }
}
