<%-- 
    Document   : profile
    Created on : Oct 13, 2018, 10:09:46 PM
    Author     : Short Corn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
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


        <!-- jQuery 2.2.0 -->
        <script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="plugins/fastclick/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/app.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="dist/js/demo.js"></script>
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

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        User Profile
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li><a href="#">Examples</a></li>
                        <li class="active">User profile</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">

                    <div class="row">
                        <div class="col-md-3">

                            <!-- Profile Image -->
                            <div class="box box-primary">
                                <div class="box-body box-profile">
                                    <img class="profile-user-img img-responsive img-circle" src="dist/img/user2-160x160.jpg" alt="User profile picture">

                                    <h3 class="profile-username text-center">Thanh</h3>

                                    <p class="text-muted text-center">Software Engineer</p>

                                    <ul class="list-group list-group-unbordered">
                                        <li class="list-group-item">
                                            <b>Followers</b> <a class="pull-right">1,322</a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Following</b> <a class="pull-right">543</a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Friends</b> <a class="pull-right">13,287</a>
                                        </li>
                                    </ul>

                                    <a href="#" class="btn btn-primary btn-block"><b>Follow</b></a>
                                </div>
                                <!-- /.box-body -->
                            </div>
                            <!-- /.box -->

                            <!-- About Me Box -->
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">About Me</h3>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <strong><i class="fa fa-book margin-r-5"></i> Education</strong>

                                    <p class="text-muted">
                                        B.S. in Computer Science from the University of Tennessee at Knoxville
                                    </p>

                                    <hr>

                                    <strong><i class="fa fa-map-marker margin-r-5"></i> Location</strong>

                                    <p class="text-muted">Malibu, California</p>

                                    <hr>

                                    <strong><i class="fa fa-pencil margin-r-5"></i> Skills</strong>

                                    <p>
                                        <span class="label label-danger">UI Design</span>
                                        <span class="label label-success">Coding</span>
                                        <span class="label label-info">Javascript</span>
                                        <span class="label label-warning">PHP</span>
                                        <span class="label label-primary">Node.js</span>
                                    </p>

                                    <hr>

                                    <strong><i class="fa fa-file-text-o margin-r-5"></i> Notes</strong>

                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam fermentum enim neque.</p>
                                </div>
                                <!-- /.box-body -->
                            </div>
                            <!-- /.box -->
                        </div>
                        <!-- /.col -->
                        <div class="col-md-9">
                            <div class="nav-tabs-custom">
                                <ul class="nav nav-tabs">

                                    <li><a href="#settings" data-toggle="tab">Settings</a></li>

                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane" id="settings">
                                        <form class="form-horizontal" method="Post" action="UpdateProfileController">
                                            <div class="form-group">
                                                <label for="inputName" class="col-sm-2 control-label">Username</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="username" placeholder="Name" name="txtUsername" value="${requestScope.DTO.username}" readonly="true">
                                                    <font color="red">
                                                    ${requestScope.INVALID.usernameError}
                                                    </font>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputName" class="col-sm-2 control-label">Password</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="password" placeholder="Password" name="txtPassword">
                                                    <font color="red">
                                                    ${requestScope.INVALID.passwordError}
                                                    </font>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputEmail" class="col-sm-2 control-label">Email</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="email" placeholder="Email" name="txtEmail" value="${requestScope.DTO.email}">
                                                    <font color="red">
                                                    ${requestScope.INVALID.emailError}
                                                    </font>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputName" class="col-sm-2 control-label">Phone number</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="phone" placeholder="Phone number" name="txtPhone" value="${requestScope.DTO.phone}">
                                                    <font color="red">
                                                    ${requestScope.INVALID.phoneNumberError}
                                                    </font>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputExperience" class="col-sm-2 control-label">Address</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="Address" placeholder="Address" name="txtAddress" value="${requestScope.DTO.address}">
                                                    <font color="red">
                                                    ${requestScope.INVALID.addressError}
                                                    </font>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputSkills" class="col-sm-2 control-label">Birthdate</label>

                                                <div class="col-sm-10">
                                                    <input type="date" class="form-control" id="birthdate" name="txtBirthdate" value="${requestScope.DTO.birthDate}">
                                                    <font color="red">
                                                    ${requestScope.INVALID.birthDateError}
                                                    </font>
                                                </div>
                                            </div>
                                            <div class="form-group">

                                                <label for="inputSkills" class="col-sm-2 control-label">Gender</label>
                                                <c:if test="${requestScope.DTO.gender!=null}">

                                                    <c:if test="${requestScope.DTO.gender==true}">
                                                        <label>Male
                                                            <input type="radio" checked="checked" name="txtGender" value="male">
                                                        </label>
                                                        <label>Female
                                                            <input type="radio" name="txtGender" value="female">

                                                        </label>
                                                    </c:if>
                                                    <c:if test="${requestScope.DTO.gender==false}">
                                                        <label>Male
                                                            <input type="radio"  name="txtGender" value="male">

                                                        </label>
                                                        <label >Female
                                                            <input type="radio" name="txtGender" value="female" checked="checked">

                                                        </label>
                                                    </c:if>
                                                </c:if>


                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox"> I agree to the <a href="#">terms and conditions</a>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <button type="submit" class="btn btn-danger">Edit Profile</button>
                                                    <input type="hidden" name="txtRole" value="admin">
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <!-- /.tab-pane -->
                                </div>
                                <!-- /.tab-content -->
                            </div>
                            <!-- /.nav-tabs-custom -->
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->

                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <%@include file="footer.jsp" %>
            <%@include file="controllSidebar.jsp" %>
        </div>

    </body>
</html>