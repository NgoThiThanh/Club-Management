<%-- 
    Document   : profileUser
    Created on : Oct 21, 2018, 9:00:39 AM
    Author     : Short Corn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Colorlib Templates">
        <meta name="author" content="Colorlib">
        <meta name="keywords" content="Colorlib Templates">

        <!-- Title Page-->
        <title>Au Register Forms by Colorlib</title>

        <!-- Icons font CSS-->
        <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
        <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <!-- Font special for pages-->
        <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">

        <!-- Vendor CSS-->
        <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

        <!-- Main CSS-->
        <link href="css/main_2.css" rel="stylesheet" media="all">
    </head>

    <body>
        <div class="page-wrapper p-t-180 p-b-100 font-robo" style="background-color: grey">
            
            <div class="wrapper wrapper--w960">
                <div class="card card-2">
                    <div class="card-heading"></div>
                    <div class="card-body">
                        <h2 class="title">PROFILE</h2>
                        <form method="POST" action="UpdateProfileController">
                            <div class="input-group">
                                Username:<input class="input--style-2" type="text" name="txtUsername" value="${requestScope.DTO.username}" readonly="true">
                                <font color="red">
                                ${requestScope.INVALID.usernameError}
                                </font>
                            </div>
                            <div class="input-group">
                                Password:<input class="input--style-2" type="password" name="txtPassword"s>
                                <font color="red">
                                ${requestScope.INVALID.passwordError}
                                </font>
                            </div>
                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group">
                                        BirthDate:<input class="input--style-2 js-datepicker" type="date" name="txtBirthdate" value="${requestScope.DTO.birthDate}">

                                        <font color="red">
                                        ${requestScope.INVALID.birthDateError}
                                        </font>
                                    </div>
                                </div>
                                <div class="col-2">
                                    <div class="input-group">
                                        <div class="rs-select2 js-select-simple select--no-search">
                                            <c:if test="${requestScope.DTO.gender!=null}">
                                                <c:if test="${requestScope.DTO.gender==true}">
                                                    <select name="txtGender">

                                                        <option selected="selected" value="male">Male</option>
                                                        <option value="female">Female</option>
                                                    </select>
                                                </c:if>
                                                <c:if test="${requestScope.DTO.gender==false}">
                                                    <select name="txtGender">

                                                        <option value="male">Male</option>
                                                        <option selected="selected" value="female">Female</option>
                                                    </select>
                                                </c:if>
                                            </c:if>
                                            <div class="select-dropdown"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="input-group">
                                Email:<input class="input--style-2" type="text" name="txtEmail" value="${requestScope.DTO.email}">
                                <font color="red">
                                ${requestScope.INVALID.emailError}
                                </font>
                            </div>
                            <div class="input-group">
                                Phone:<input class="input--style-2" type="text" name="txtPhone" value="${requestScope.DTO.phone}">
                                <font color="red">
                                ${requestScope.INVALID.phoneNumberError}
                                </font>
                            </div>
                            <div class="input-group">
                                Address:<input class="input--style-2" type="text" name="txtAddress" value="${requestScope.DTO.address}">
                                <font color="red">
                                ${requestScope.INVALID.addressError}
                                </font>
                            </div>
                            <div class="p-t-30">
                                <button class="btn btn--radius btn--green" type="submit">Edit Profile</button><br><br>
                                <a href="LoadIndexDataController">Back to Home Page</a>
                                
                            </div>
                                <input type="hidden" name="txtRole" value="user">
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Jquery JS-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <!-- Vendor JS-->
        <script src="vendor/select2/select2.min.js"></script>
        <script src="vendor/datepicker/moment.min.js"></script>
        <script src="vendor/datepicker/daterangepicker.js"></script>

        <!-- Main JS-->
        <script src="js/global.js"></script>

    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->
