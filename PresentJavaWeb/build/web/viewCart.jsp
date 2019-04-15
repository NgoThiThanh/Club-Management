<%-- 
    Document   : contestManager
    Created on : Oct 7, 2018, 1:36:54 PM
    Author     : Short Corn
--%>


<%@page import="thanh.dtos.ContestInfoDTO"%>
<%@page import="thanh.beans.LikeCartObj"%>
<%@page import="thanh.dtos.PrizeDTO"%>
<%@page import="java.util.List"%>
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
                        User Managerment Table
                        <small>have a wonderful day!</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li><a href="#">Tables</a></li>
                        <li class="active">Simple</li>
                    </ol>
                </section>
                
                <% LikeCartObj shoppingCart=(LikeCartObj) session.getAttribute("cartt"); %>
   
                
                        <!-- Main content -->
                        <section class="content">
                            <div class="row">
                                <div class="col-md-12">
                                    
                                    <div class="box">
                                        <div class="box-header with-border">
                                            <font color="blue"><h3>Provide prize for <%= request.getParameter("txtContestID") %> - <%= request.getParameter("txtContestName")%></h3></font>
                                            
                                        </div>
                                        

                                        <!-- /.box-header -->
                                        <div class="box-body">
                                            <form action="MainController" method="post"> 
                                                <%
                                                if(shoppingCart!=null){
                                                    
                                                
                                                %>
                                            <table class="table table-bordered">
                                                <tr>
                                                    <th style="width: 10px">No</th>
                                                   
                                                    <th>Prize</th>
                                                    <th>Price</th>
                                                    <th>Quantity</th>
                                                    <th>For Rank?</th>
                                                    <th>Action</th>
                                                    
                                                </tr>
                                                
                                               <% int count = 0;
                                                    float sum=0;
                                                    for (ContestInfoDTO dto : shoppingCart.getCart().values()) {
                                                        sum+= dto.getQuantity()*dto.getPrice();
                                                        count++;
                                                %>
                                                
                                                    <tr>
                                                        <td><%= count %></td>
                                                        
                                                        <td><%= dto.getPrizeId() %> </td>
                                                        <td><%= dto.getPrice() %></td>
                                                        <td>
                                                            <input type="number" name="txtQuantity" min="1" max="<%=dto.getQuantityInPrize()%>" value="<%= dto.getQuantity() %>"/>
                                                            <input type="hidden" name="txtPriceId" value="<%= dto.getPrizeId() %>"/>
                                                        </td>
                                                        <td><input type="number" name="txtRank" min="1" max="3" value="<%= dto.getRewardRank() %>"/></td>
                                                        <td><input type="checkbox" name="chkRemove" value="<%= dto.getPrizeId()%>"/></td>
                                                    </tr>
                                                   
                                                    
                                                <%}%> 
                                                
                                                    <tr>
                                                        <td></td>
                                                        
                                                        <td><a href="MainController?action=providePrizee&txtContestID=<%= request.getParameter("txtContestID")%>&txtContestName=<%= request.getParameter("txtContestName")%>&txtRank=<%= request.getParameter("txtRank")%>"> Continue adding prizes</a></td>
                                                        <td>Total: <%= sum %> </td>
                                                        <td>
                                                            <input type="submit" name="action" value="RemoveCart"/>
                                                            <input type="hidden" name="txtContestID" value="<%= request.getParameter("txtContestID")%>"/>
                                                            <input type="hidden" name="txtContestName" value="<%= request.getParameter("txtContestName")%>"/>
                                                            <input type="hidden" name="txtRank" value="<%= request.getParameter("txtRank")%>"/>
                                                        </td>
                                                        <td>
                                                            <input type="submit" name="action" value="UpdateCart"/> 
                                                            <input type="hidden" name="txtContestID" value="<%= request.getParameter("txtContestID")%>"/>
                                                            <input type="hidden" name="txtContestName" value="<%= request.getParameter("txtContestName")%>"/>
                                                            <input type="hidden" name="txtQuantity" value="<%= request.getParameter("txtQuantity")%>"/>
                                                            <input type="hidden" name="txtRank" value="<%= request.getParameter("txtRank")%>"/>
                                                        </td>
                                                        <td>
                                                            <% 
                                                                int countMax=0;
                                                                for (ContestInfoDTO dto : shoppingCart.getCart().values()) {
                                                                    if(dto.getQuantity()> dto.getQuantityInPrize()){
                                                                        countMax++;
                                                                    }
                                                                }
                                                                if(countMax>0){
                                                            %>
                                                            <input type="submit" name="action" value="SaveCart" disabled="disabled" class="disabled"/> 
                                                            <%
                                                                }
                                                            else{
                                                            %> 
                                                                <input type="submit" name="action" value="SaveCart"/>
                                                            <% }
                                                            %>
                                                        </td>
                                                        <td></td>
                                                        
                                                    </tr>
                                            </table>
                                            <%
                                            }else{
                                                   out.println("No prize was added!");
                                            %>
                                            <a href="providePrize.jsp?txtContestID=<%= request.getParameter("txtContestID") %>&txtContestName=<%= request.getParameter("txtContestName") %>">Provide prize for this contest...</a>
                                            <%
                                            }
                                            %>
                                        </form>

                                    </div>
                                    <!-- /.box-body -->
                                    <div class="box-footer clearfix">
                                        <ul class="pagination pagination-sm no-margin pull-right">
                                            <li><a href="#">&laquo;</a></li>
                                            <li><a href="#">1</a></li>
                                            <li><a href="#">2</a></li>
                                            <li><a href="#">3</a></li>
                                            <li><a href="#">&raquo;</a></li>
                                        </ul>
                                    </div>




                                </div>
                                <!-- /.box -->
                            </div>
                        </div>
                    </section>
             

            </div>
            

            <%@include file="footer.jsp" %>
            <%@include file="controllSidebar.jsp" %>
        </div>

    </body>
</html>