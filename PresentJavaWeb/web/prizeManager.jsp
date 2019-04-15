
<%-- 
    Document   : contestManager
    Created on : Oct 7, 2018, 1:36:54 PM
    Author     : Short Corn
--%>

<%@page import="java.util.List"%>
<%@page import="thanh.dtos.ContestDTO"%>
<%@page import="thanh.daos.ContestDAO"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <script src="prizeValidation.js"></script>

        
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
                        Prize Managerment Table
                        <small>have a wonderful day!</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li><a href="#">Tables</a></li>
                        <li class="active">Simple</li>
                    </ol>
                </section>
                <form action="insertPrize.jsp" method="POST">
                    <div class="box-footer clearfix no-border">
                        <button type="submit" class="btn btn-default pull-right"><i class="fa fa-plus"></i> Add Prize</button>
                    </div>
                </form>
                
                <c:if test="${requestScope.INFO!=null}">
                <c:if test="${not empty requestScope.INFO}" var="data">
                        <!-- Main content -->
                        <section class="content">
                            <div class="row">
                                <div class="col-md-12">
                                    
                                    <div class="box">
                                        <div class="box-header with-border">
                                            <form action="PrizeMainController" method="POST" onsubmit="return validateSearchPrize()">
                                                Min Price:<input type="text" name="txtMinPrice" id="minPrice" value="${param.txtMinPrice}">
                                                <span id="minPrice-error" style="color: red"></span>
                                                Max Price:<input type="text" name="txtMaxPrice" id="maxPrice" value="${param.txtMaxPrice}">
                                                <span id="maxPrice-error" style="color: red"></span>
                                                <input type="submit" value="SEARCH" name="action">
                                            </form>
                                            
                                        </div>
                                        

                                        <!-- /.box-header -->
                                        <div class="box-body">
                                            <table class="table table-bordered">
                                                <tr>
                                                    <th style="width: 10px">No</th>
                                                    <th>Prize ID</th>
                                                    <th>Prize Name</th>
                                                    <th>Price</th>
                                                    <th>Quantity</th>
                                                    <th>Edit</th>
                                                    <th>Remove</th>
                                                </tr>

                                                <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                                                    <tr>
                                                        <td>${counter.count}</td>
                                                        <td>${dto.prizeId}</td>
                                                        <td>${dto.prizeName}</td>
                                                        <td>${dto.price}</td>
                                                        
                                                        <td><span class="badge bg-green">${dto.quantity}</span></td>
                                                        <td>
                                                            <c:url value="PrizeMainController" var="edit">
                                                                <c:param name="txtPrizeId" value="${dto.prizeId}"/>
                                                                <c:param name="action" value="edit"/>
                                                                <c:param name="txtMinPrice" value="${param.txtMinPrice}"/>
                                                                <c:param name="txtMaxPrice" value="${param.txtMaxPrice}"/>
                                                                
                                                            </c:url>
                                                                
                                                            <a href="${edit}"><span class="label label-warning">edit</span></a>
                                                        </td>
                                                        <td>
                                                            <c:url value="PrizeMainController" var="delete">
                                                                <c:param name="txtPrizeId" value="${dto.prizeId}"/>
                                                                <c:param name="action" value="delete"/>
                                                                <c:param name="txtMinPrice" value="${param.txtMinPrice}"/>
                                                                <c:param name="txtMaxPrice" value="${param.txtMaxPrice}"/>
                                                                
                                                            </c:url>
                                                                
                                                            <a href="${delete}"><span class="label label-danger">Delete</span></a>
                                                        </td>

                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        

                                    </div>
                                    <!-- /.box-body -->
                                    <div class="box-footer clearfix">
                                        <ul class="pagination pagination-sm no-margin pull-right">
                                            
                                            <c:if test="${pageNumber==1 && numberOfPage!=1 && numberOfPage!=2}">
                                            <li class="disabled"><a>&laquo;</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=1">1</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=2">2</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=3">3</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=${pageNumber+1}">&raquo;</a></li>
                                            </c:if>
                                            <c:if test="${pageNumber==numberOfPage && numberOfPage!=1 && numberOfPage!=2}">
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=${pageNumber-1}">&laquo;</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=1">1</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=2">2</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=3">3</a></li>
                                            <li class="disabled"><a>&raquo;</a></li>
                                            </c:if>
                                            <c:if test="${pageNumber!=numberOfPage && pageNumber!=1 && numberOfPage!=1 && numberOfPage!=2}">
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=${pageNumber-1}">&laquo;</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=1">1</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=2">2</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=3">3</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=${pageNumber+1}">&raquo;</a></li>
                                            </c:if>
                                            <c:if test="${numberOfPage==1}">
                                            <li class="disabled"><a>&laquo;</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=1">1</a></li>
                                            <li class="disabled"><a>&raquo;</a></li>
                                            </c:if>
                                            <c:if test="${numberOfPage==2 && pageNumber==1}">
                                            <li  class="disabled"><a>&laquo;</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=1">1</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=2">2</a></li>
                                            
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=${pageNumber+1}">&raquo;</a></li>
                                            </c:if>
                                            <c:if test="${numberOfPage==2 && pageNumber==numberOfPage}">
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=${pageNumber-1}">&laquo;</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=1">1</a></li>
                                            <li><a href="PrizeMainController?action=loadPrizeData&pageId=2">2</a></li>
                                            
                                            <li  class="disabled"><a>&raquo;</a></li>
                                            </c:if>
                                        </ul>
                                        <h3>Page: ${pageNumber}/${numberOfPage}</h3>
                                    </div>




                                </div>
                                <!-- /.box -->
                            </div>
                        </div>
                    </section>
                        
                        
                    </c:if>
                        <c:if test="${data==false}">
                            No record found!
                        </c:if>
                </c:if>
               
            </div>
            

            <%@include file="footer.jsp" %>
            <%@include file="controllSidebar.jsp" %>
        </div>

    </body>
</html>