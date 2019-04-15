/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validInsertContest() {

var contestID = document.getElementById('contestId').value;
    var contestName = document.getElementById('contestName').value;
    var contestAddress = document.getElementById('Address').value;
    var endDateRegistration = document.getElementById('endRegist').value;
    var startDate = document.getElementById('startDate').value;
    var endDate = document.getElementById('endDate').value;
    

    var validContestID = document.getElementById('contestId-error');
    var validContestName = document.getElementById('contestName-error');
    var validContestAddress = document.getElementById('Address-error');
    var validEndDateRegistration = document.getElementById('endRegist-error');
    var validStartDate = document.getElementById('startDate-error');
    var validEndDate = document.getElementById('endDate-error');
    
    
    

    if (contestID.length === 0) {
        validContestID.innerHTML = "Contest Id can't be blank!";
        return false;
    } else {
        validContestID.innerHTML = "";
    }


    if (contestName.length === 0) {
        validContestName.innerHTML = "Contest Name can't be blank!";
        return false;
    } else {
        validContestName.innerHTML = "";
    }
    
    
    if (contestAddress.length === 0) {
        validContestAddress.innerHTML = "Address can't be blank!";
        return false;
    } else {
        validContestAddress.innerHTML = "";
    }
    
    
    
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();

    if(dd<10) {
        dd = '0'+dd;
    } 

    if(mm<10) {
        mm = '0'+mm;
    } 

    today = yyyy+"-"+mm+"-"+dd+" 24:00:00";
 

    if (endDateRegistration.length === 0) {
        validEndDateRegistration.innerHTML = "*Required";
        return false;
    }
    else if(today>=endDateRegistration){
        validEndDateRegistration.innerHTML = "endDateRegistration must >= today";
        return false;
    } 
    else {
        validEndDateRegistration.innerHTML = "";
        
    }
    
    
    if (startDate.length === 0) {
        validStartDate.innerHTML = "*Required";
        return false;
    }
    else if(startDate< endDateRegistration){
        validStartDate.innerHTML = "startDate must >= endDateRegistration";
        return false;
    } 
    else {
        validStartDate.innerHTML = "";
    }



    if (endDate.length === 0) {
        validEndDate.innerHTML = "*Required";
        return false;
    }
    if(endDate< startDate){
        validEndDate.innerHTML = "end date must >= start date";
        return false;
    }
    else {
        validEndDate.innerHTML = "";
    }
    
    
    
   
    


}
function validUpdateContest() {

var contestID = document.getElementById('contestId').value;
    var contestName = document.getElementById('contestName').value;
    var contestAddress = document.getElementById('Address').value;
    var endDateRegistration = document.getElementById('endRegist').value;
    var startDate = document.getElementById('startDate').value;
    var endDate = document.getElementById('endDate').value;
    

    var validContestID = document.getElementById('contestId-error');
    var validContestName = document.getElementById('contestName-error');
    var validContestAddress = document.getElementById('Address-error');
    var validEndDateRegistration = document.getElementById('endRegist-error');
    var validStartDate = document.getElementById('startDate-error');
    var validEndDate = document.getElementById('endDate-error');
    
    
    

    if (contestID.length === 0) {
        validContestID.innerHTML = "Contest Id can't be blank!";
        return false;
    } else {
        validContestID.innerHTML = "";
    }


    if (contestName.length === 0) {
        validContestName.innerHTML = "Contest Name can't be blank!";
        return false;
    } else {
        validContestName.innerHTML = "";
    }
    
    
    if (contestAddress.length === 0) {
        validContestAddress.innerHTML = "Address can't be blank!";
        return false;
    } else {
        validContestAddress.innerHTML = "";
    }
    
    
    
    
 

    if (endDateRegistration.length === 0) {
        validEndDateRegistration.innerHTML = "*Required";
        return false;
    }
     
    else {
        validEndDateRegistration.innerHTML = "";
        
    }
    
    
    if (startDate.length === 0) {
        validStartDate.innerHTML = "*Required";
        return false;
    }
    else if(startDate< endDateRegistration){
        validStartDate.innerHTML = "startDate must >= endDateRegistration";
        return false;
    } 
    else {
        validStartDate.innerHTML = "";
    }



    if (endDate.length === 0) {
        validEndDate.innerHTML = "*Required";
        return false;
    }
    if(endDate< startDate){
        validEndDate.innerHTML = "end date must >= start date";
        return false;
    }
    else {
        validEndDate.innerHTML = "";
    }
    
    
    
   
    


}
function validateSearchValue(){
    var fromDate=document.getElementById('fromDate').value;
    var toDate=document.getElementById('toDate').value;
    
    var validFromDate=document.getElementById('fromDate-error');
    var validToDate=document.getElementById('toDate-error');
    
    if(fromDate===""){
        validFromDate.innerHTML="*Required";
        return false;
    }else{
        validFromDate.innerHTML="";
    }
    if(toDate===""){
        validToDate.innerHTML="*Required";
        return false;
    }else{
        validToDate.innerHTML="";
    }
    
    if(fromDate>toDate){
        validFromDate.innerHTML="From date must be <= To Date";
        return false;
    }else{
        validFromDate.innerHTML="";
    }
    
}

