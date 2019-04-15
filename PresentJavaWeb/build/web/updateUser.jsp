<%-- 
    Document   : updateUser
    Created on : Oct 9, 2018, 9:08:10 PM
    Author     : Short Corn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
        <!-- Morris chart -->
        <link rel="stylesheet" href="plugins/morris/morris.css">
        <!-- jvectormap -->
        <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
        <!-- Date Picker -->
        <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
        <!-- Daterange picker -->
        <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker-bs3.css">
        <!-- bootstrap wysihtml5 - text editor -->
        <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">





        <!-- Icons font CSS-->
        <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
        <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <!-- Font special for pages-->
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Vendor CSS-->
        <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

        <!-- Main CSS-->
        <link href="css/main_1.css" rel="stylesheet" media="all">

        <!-- jQuery 2.2.0 -->
        <script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
        <!-- jQuery UI 1.11.4 -->
        <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
        <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
        <script>
            $.widget.bridge('uibutton', $.ui.button);
        </script>
        <!-- Bootstrap 3.3.6 -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <!-- Morris.js charts -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="plugins/morris/morris.min.js"></script>
        <!-- Sparkline -->
        <script src="plugins/sparkline/jquery.sparkline.min.js"></script>
        <!-- jvectormap -->
        <script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
        <!-- jQuery Knob Chart -->
        <script src="plugins/knob/jquery.knob.js"></script>
        <!-- daterangepicker -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
        <script src="plugins/daterangepicker/daterangepicker.js"></script>
        <!-- datepicker -->
        <script src="plugins/datepicker/bootstrap-datepicker.js"></script>
        <!-- Bootstrap WYSIHTML5 -->
        <script src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
        <!-- Slimscroll -->
        <script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
        <!-- FastClick -->
        <script src="plugins/fastclick/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/app.min.js"></script>
        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="dist/js/pages/dashboard.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="dist/js/demo.js"></script>
        <style>
            ::placeholder{
                color: #D0ECE7 !important;
            }
        </style>



    </head>
    <body class="hold-transition skin-blue sidebar-mini">
<c:if test="${sessionScope.CURRENT_ROLE == null || sessionScope.CURRENT_ROLE=='user'}" var="checkRole">
            <c:url value="LoadIndexDataController" var="failRole">
                
            </c:url>
            <c:redirect url="${failRole}"/>
        </c:if>

        <div class="wrapper">
            <%@include file="header.jsp" %>
            <%@include file="menu.jsp" %>

            <div class="content-wrapper">



                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Update user
                        <small>have a wonderful day!</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li><a href="#">Tables</a></li>
                        <li class="active">Simple</li>
                    </ol>
                </section>
                <section class="content">
                
                <div class="page-wrapper p-t-130 p-b-100 font-poppins" style="background-color: #F8F9F9  ">
                    <div class="wrapper wrapper--w680">
                        <div class="card card-4">
                            <div class="card-body">
                                <h2 class="title">Update user Form</h2>
                                <form method="POST" action="UserMainController">
                                    <div class="row row-space">
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Username</label>
                                                <input class="input--style-4" type="text" name="txtUsername" value="${requestScope.DTO.username}" readonly="true" >
                                                <font color="red">
                                                    ${requestScope.INVALID.usernameError}
                                                </font>
                                            </div>
                                        </div>
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Password</label>
                                                <input class="input--style-4" type="password" name="txtPassword" placeholder="any keys...">
                                                <font color="red">
                                                    ${requestScope.INVALID.passwordError}
                                                </font>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row row-space">
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Birthday</label>
                                                <div class="input-group">
                                                    <input class="input--style-4" type="date" name="txtBirthDate" value="${requestScope.DTO.birthDate}">
                                                    <font color="red">
                                                    ${requestScope.INVALID.birthDateError}
                                                    </font>

                                                </div>
                                            </div>
                                        </div>
                                        <c:if test="${requestScope.DTO.gender!=null}">
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Gender</label>
                                                <div class="p-t-10">
                                                    
                                                        <c:if test="${requestScope.DTO.gender==true}">
                                                            <label class="radio-container m-r-45">Male
                                                            <input type="radio" checked="checked" name="txtGender" value="male">
                                                            <span class="checkmark"></span>
                                                            </label>
                                                            <label class="radio-container">Female
                                                                <input type="radio" name="txtGender" value="female">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                        </c:if>
                                                        <c:if test="${requestScope.DTO.gender==false}">
                                                            <label class="radio-container m-r-45">Male
                                                            <input type="radio"  name="txtGender" value="male">
                                                            <span class="checkmark"></span>
                                                            </label>
                                                            <label class="radio-container">Female
                                                                <input type="radio" name="txtGender" value="female" checked="checked">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                        </c:if>
                                                    
                                                    
                                                    
                                                </div>
                                            </div>
                                        </div>
                                        </c:if>
                                        <c:if test="${requestScope.DTO.gender==null}">
                                            <div class="col-2">
                                                <div class="input-group">
                                                    <label class="label">Gender</label>
                                                    <div class="p-t-10">
                                                                <label class="radio-container m-r-45">Male
                                                                    <input type="radio" checked="checked" name="txtGender" value="male">

                                                                    <span class="checkmark"></span>
                                                                </label>
                                                                <label class="radio-container">Female
                                                                <input type="radio" name="txtGender" value="female">
                                                            <span class="checkmark"></span>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </div>
                                    <div class="row row-space">
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Email</label>
                                                <input class="input--style-4" type="text" name="txtEmail" value="${requestScope.DTO.email}" placeholder="ex: dog@gmail.com">
                                                <font color="red">
                                                    ${requestScope.INVALID.emailError}
                                                </font>
                                            </div>
                                        </div>
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Phone Number</label>
                                                <input class="input--style-4" type="text" name="txtPhone" value="${requestScope.DTO.phone}" placeholder="10-11 numbers">
                                                <font color="red">
                                                    ${requestScope.INVALID.phoneNumberError}
                                                </font>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row row-space">
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Address</label>
                                                <input class="input--style-4" type="text" name="txtAddress" value="${requestScope.DTO.address}">
                                                <font color="red">
                                                    ${requestScope.INVALID.addressError}
                                                </font>
                                            </div>
                                        </div>
                                        <div class="col-2">
                                            <div class="input-group">
                                                <label class="label">Role</label>
                                                <input class="input--style-4" type="text" name="txtRole" value="${requestScope.DTO.role}" placeholder="user/admin">
                                                <font color="red">
                                                    ${requestScope.INVALID.roleError}
                                                </font>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="p-t-15">
                                        <button class="btn btn--radius-2 btn--blue" type="submit" name="action" value="update">Update</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                </section>
                

                <%@include file="footer.jsp" %>
                <%@include file="controllSidebar.jsp" %>
            </div>
<!-- Jquery JS-->
                <script src="vendor/jquery/jquery.min.js"></script>
                <!-- Vendor JS-->
                <script src="vendor/select2/select2.min.js"></script>
                <script src="vendor/datepicker/moment.min.js"></script>
                <script src="vendor/datepicker/daterangepicker.js"></script>

                <!-- Main JS-->
                <script src="js/global.js"></script>
    </body>
</html>
