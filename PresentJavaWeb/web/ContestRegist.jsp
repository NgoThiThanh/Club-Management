<%-- 
    Document   : ContestRegist
    Created on : Oct 20, 2018, 10:01:25 AM
    Author     : Short Corn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <!-- 
                Template 2047 Brown Field
                by www.tooplate.com 
        -->
        <title>Brown Field Template</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="css/tooplate_style.css" rel="stylesheet" type="text/css" />

        <script type="text/javascript" src="js/swfobject.js"></script>
        <script type="text/javascript">
            var flashvars = {};
            flashvars.xml_file = "photo_list.xml";
            var params = {};
            params.wmode = "transparent";
            var attributes = {};
            attributes.id = "slider";
            swfobject.embedSWF("flash_slider.swf", "flash_grid_slider", "440", "220", "9.0.0", false, flashvars, params, attributes);
        </script> 

        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>

    </head>
    <body>

        <div id="tooplate_wrapper">

            <div id="tooplate_header">
                <div id="site_title">
                    
                </div>

            </div> <!-- end of forever header -->


            <div id="tooplate_main_top"></div>
            <div id="tooplate_main">
                <form action="User_ContestController" method="post">
                <div class="col_w900">
                    <div class="con_tit_01" style="color: brown">Contest Registration</div>
                    <img src="img/coVua.png" alt="Image 01" class="image_wrapper image_fl" style="width: 300px; height: 200px" />

                    <p align="justify"><span style="color: #935116;"><strong>CONTEST:</strong></span> ${param.txtContestId} - ${requestScope.CONTEST_DTO.contestName}</p>	
                    <p align="justify"><span style="color: #935116;"><strong>CREATED DATE:</strong></span> ${requestScope.CONTEST_DTO.startDateRegistration}</p>	
                    <p align="justify"><span style="color: #935116;"><strong>END REGISTRATION DATE:</strong></span> ${requestScope.CONTEST_DTO.endDateRegistration}</p>	
                    <p align="justify"><span style="color: #935116;"><strong>START COMPETITION DATE:</strong></span> ${requestScope.CONTEST_DTO.startDate}</p>	
                    <p align="justify"><span style="color: #935116;"><strong>START COMPETITION DATE:</strong></span> ${requestScope.CONTEST_DTO.endDate}</p>	
                    <p align="justify"><span style="color: #935116;"><strong>CONTEST ADDRESS:</strong></span> ${requestScope.CONTEST_DTO.contestAddress}</p>	
                    <p align="justify"><span style="color: #935116;"><strong>STATUS:</strong></span> ${requestScope.CONTEST_DTO.status}</p>	
                    <p align="justify"><span style="color: #935116;"><strong>ABOUT THE CONTEST:</strong></span> ${requestScope.CONTEST_DTO.description}</p>	

                    <div class="cleaner"></div>
                </div>

                <div class="col_w900 col_w900_last">


                    <h2 style="color: brown">PRIZES FOR CONTEST</h2>
                    <table style="margin: auto;">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Prize</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>For Rank</th>
                               

                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="sum" value="${0}"/>
                            <c:forEach items="${requestScope.INFO}" var="contestInfoDto" varStatus="counter">
                                <c:set var="sum" value="${sum + contestInfoDto.quantity * contestInfoDto.price}"/>
                                
                                
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${contestInfoDto.prizeId}-${contestInfoDto.prizeName}</td>
                                    <td>${contestInfoDto.quantity}</td>
                                    <td>${contestInfoDto.price}</td>
                                    <td>${contestInfoDto.rewardRank}</td>
                                    

                                </tr>
                            </c:forEach>
                            <tr>
                                <th></th>
                                <th></th>
                                <th></th>
                                <th>Total Prize: ${sum}</th>
                                <th></th>
                                

                            </tr>
                        </tbody>
                        
                    </table>


                    </div>
                                
                <div class="cleaner"></div>
                <div class="col_w900 col_w900_last">
                    <h2 style="color: brown">REWARDING FOR PLAYER</h2>
                    <c:forEach items="${requestScope.USER_RANK}" var="ur">
                        <h3>Rank number ${ur.rank}:   ${ur.username} </h3>
                    </c:forEach>
                </div>
                <div class="cleaner"></div>
                <br>
                    <c:if test="${requestScope.CONTEST_DTO.status == 'Not Start' }">
                        <input type="submit" value="REGIST" name="action"> <font color="red">${requestScope.INVALID}</font>
                    </c:if>
                        <input type="hidden" name="txtContestId" value="${param.txtContestId}"/>
                        <br><a href="LoadIndexDataController">Back to Home Page</a>
                            
                </form>
            </div> <!-- end of main -->
            <div id="tooplate_main_bottom"></div>

        </div> <!-- wrapper -->

        <div id="tooplate_footer_wrapper">
            <div id="tooplate_footer">
                Copyright © 2048 <a href="#">Company Name</a> 
                | Design: <a href="http://www.tooplate.com">tooplate</a>
            </div>
        </div>

    </body>
</html>