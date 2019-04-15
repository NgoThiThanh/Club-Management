/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.dtos;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Short Corn
 */
public class ContestDTO implements Serializable{

    String contestID, contestName, contestAddress, status, description;
    Timestamp  startDateRegistration,endDateRegistration,startDate,endDate;
    

    public ContestDTO() {
    }

    public ContestDTO(String contestID, String contestName, String contestAddress, String status, String description, Timestamp endDateRegistration, Timestamp startDate, Timestamp endDate) {
        this.contestID = contestID;
        this.contestName = contestName;
        this.contestAddress = contestAddress;
        this.status = status;
        this.description = description;
        this.endDateRegistration = endDateRegistration;
        this.startDate = startDate;
        this.endDate = endDate;
        
    }

    public ContestDTO(String contestID, String contestName, String contestAddress, String status, Timestamp startDate, Timestamp endDate) {
        this.contestID = contestID;
        this.contestName = contestName;
        this.contestAddress = contestAddress;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
       
    }

    public ContestDTO(String contestID, String contestName, String contestAddress, String status, String description, Timestamp startDateRegistration, Timestamp endDateRegistration, Timestamp startDate, Timestamp endDate) {
        this.contestID = contestID;
        this.contestName = contestName;
        this.contestAddress = contestAddress;
        this.status = status;
        this.description = description;
        this.startDateRegistration = startDateRegistration;
        this.endDateRegistration = endDateRegistration;
        this.startDate = startDate;
        this.endDate = endDate;
        
    }

    public ContestDTO(String contestID, String contestName, String description, Timestamp startDateRegistration, Timestamp endDateRegistration, Timestamp startDate, Timestamp endDate) {
        this.contestID = contestID;
        this.contestName = contestName;
        this.description = description;
        this.startDateRegistration = startDateRegistration;
        this.endDateRegistration = endDateRegistration;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getContestID() {
        return contestID;
    }

    public void setContestID(String contestID) {
        this.contestID = contestID;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public String getContestAddress() {
        return contestAddress;
    }

    public void setContestAddress(String contestAddress) {
        this.contestAddress = contestAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getStartDateRegistration() {
        return startDateRegistration;
    }

    public void setStartDateRegistration(Timestamp startDateRegistration) {
        this.startDateRegistration = startDateRegistration;
    }

    public Timestamp getEndDateRegistration() {
        return endDateRegistration;
    }

    public void setEndDateRegistration(Timestamp endDateRegistration) {
        this.endDateRegistration = endDateRegistration;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

   
    
}
