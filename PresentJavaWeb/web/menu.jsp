<%-- 
    Document   : menu
    Created on : Oct 6, 2018, 1:30:46 PM
    Author     : Short Corn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <!-- Left side column. contains the logo and sidebar -->
        <aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">
                <!-- Sidebar user panel -->
                <div class="user-panel">
                    <div class="pull-left image">
                        <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                    </div>
                    <div class="pull-left info">
                        <p>${sessionScope.CURRENT_USER}</p>
                        <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                    </div>
                </div>
                <!-- search form -->
                <form action="#" method="get" class="sidebar-form">
                    <div class="input-group">
                        <input type="text" name="q" class="form-control" placeholder="Search...">
                        <span class="input-group-btn">
                            <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                            </button>
                        </span>
                    </div>
                </form>
                <!-- /.search form -->
                <!-- sidebar menu: : style can be found in sidebar.less -->
                <ul class="sidebar-menu">
                    <li class="header">MAIN NAVIGATION</li>
                    <li class="active treeview">
                        <a href="indexAdmin.jsp">
                            <i class="fa fa-dashboard"></i> <span>Home</span> <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        
                    </li>
                    <li class="treeview">
                        <a href="MainController?action=loadContestData&pageId=1">
                            <i class="fa fa-files-o"></i>
                            <span>Contest Managerment</span>
                            <span class="label label-primary pull-right">4</span>
                        </a>
                       
                    </li>
                    <li>
                        <a href="UserMainController?action=loadUserData&pageId=1">
                            <i class="fa fa-th"></i> <span>User Managerment</span>
                            <small class="label pull-right bg-green">new</small>
                        </a>
                    </li>
                    <li class="treeview">
                        <a href="PrizeMainController?action=loadPrizeData&pageId=1">
                            <i class="fa fa-pie-chart"></i>
                            <span>Prize Managerment</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        
                    </li>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-laptop"></i>
                            <span>Just for fun</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="#"><i class="fa fa-circle-o"></i> General</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> Icons</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> Buttons</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> Sliders</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> Timeline</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> Modals</a></li>
                        </ul>
                    </li>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-edit"></i> <span>Just for fun</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="#"><i class="fa fa-circle-o"></i> General Elements</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> Advanced Elements</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> Editors</a></li>
                        </ul>
                    </li>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-table"></i> <span>Just for fun</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="#"><i class="fa fa-circle-o"></i> Simple tables</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> Data tables</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-calendar"></i> <span>Just for fun</span>
                            <small class="label pull-right bg-red">3</small>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-envelope"></i> <span>Just for fun</span>
                            <small class="label pull-right bg-yellow">12</small>
                        </a>
                    </li>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-folder"></i> <span>Just for fun</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="#"><i class="fa fa-circle-o"></i> Invoice</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> Profile</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> Login</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> Register</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> Lockscreen</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> 404 Error</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> 500 Error</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> Blank Page</a></li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> Pace Page</a></li>
                        </ul>
                    </li>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-share"></i> <span>Just for fun</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="#"><i class="fa fa-circle-o"></i> Level One</a></li>
                            <li>
                                <a href="#"><i class="fa fa-circle-o"></i> Level One <i class="fa fa-angle-left pull-right"></i></a>
                                <ul class="treeview-menu">
                                    <li><a href="#"><i class="fa fa-circle-o"></i> Level Two</a></li>
                                    <li>
                                        <a href="#"><i class="fa fa-circle-o"></i> Level Two <i class="fa fa-angle-left pull-right"></i></a>
                                        <ul class="treeview-menu">
                                            <li><a href="#"><i class="fa fa-circle-o"></i> Level Three</a></li>
                                            <li><a href="#"><i class="fa fa-circle-o"></i> Level Three</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li><a href="#"><i class="fa fa-circle-o"></i> Just for fun</a></li>
                        </ul>
                    </li>
                    <li><a href="#"><i class="fa fa-book"></i> <span>Just for fun</span></a></li>
                    <li class="header">Just for fun</li>
                    <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Just for fun</span></a></li>
                    <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Just for fun</span></a></li>
                    <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Just for fun</span></a></li>
                </ul>
            </section>
            <!-- /.sidebar -->
        </aside>


    </body>
</html>
