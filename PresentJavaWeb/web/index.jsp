<%-- 
    Document   : index
    Created on : Oct 7, 2018, 6:31:46 PM
    Author     : Short Corn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--
Template Name: Exative
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<html>
<head>
<title>Exative</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
</head>
<body id="top">
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row1">
  <header id="header" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <div id="logo" class="fl_left">
      <h1><a href="#">Chess Club</a></h1>
    </div>
    <nav id="mainav" class="fl_right">
      <ul class="clear">
        <li class="active"><a href="#">Home</a></li>
        <li><a class="drop" href="#">CONTEST</a>
          <ul>
            <li><a href="LoadIndexDataController">Not Start Contest</a></li>
            <li><a href="LoadDoingContestController">Doing Contest</a></li>
            <li><a href="LoadFinishedController">Finished Contest</a></li>
            
          </ul>
        </li>
        
        
        <li><a class="drop" href="#">Welcome ${sessionScope.CURRENT_USER}</a>
            <c:if test="${sessionScope.CURRENT_USER!=null}">
                <ul>
                    <li><a href="ProfileController">Profile</a></li>
                    <li><a href="LoadRegistedContest">Registed Contest</a></li>
                </ul>
            </c:if>
          
        </li>
        <c:if test="${sessionScope.CURRENT_ROLE=='admin'}">
            <li><a href="indexAdmin.jsp">ADMIN MANAGERMENT</a></li>
        </c:if>
        <c:if test="${sessionScope.CURRENT_USER!=null}">
         <li><a href="LogOutController">LOG OUT</a></li>
        </c:if>
      </ul>
    </nav>
    <!-- ################################################################################################ -->
  </header>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="bgded overlay" style="background-image:url('img/coVua3.jpg');">
  <div id="pageintro" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <div class="flexslider basicslider">
      <ul class="slides">
        <li>
          <article>
            <h3 class="heading">No one can win the game of chess</h3>
            <p>by moving forward only.Sometimes one has to move backward also </p>
            <p class="font-x1 uppercase bold">To get a better move.</p>
            <footer>
                <c:if test="${sessionScope.CURRENT_USER==null}">
              <ul class="nospace inline pushright">
                <li><a class="btn" href="login.jsp">  LOGIN  </a></li>
                <li><a class="btn inverse" href="registrationForm.jsp">REGISTRY</a></li>
              </ul>
                </c:if>
            </footer>
          </article>
        </li>
        <li>
          <article>
            <h3 class="heading">You may learn much more </h3>
            <p>from a game you lose than from a game you win. You will have to lose hundreds of games</p>
            <p class="font-x1 uppercase bold">before becoming a good player.</p>
            <footer>
              <c:if test="${sessionScope.CURRENT_USER==null}">
              <ul class="nospace inline pushright">
                <li><a class="btn" href="login.jsp">  LOGIN  </a></li>
                <li><a class="btn inverse" href="registrationForm.jsp">REGISTRY</a></li>
              </ul>
                </c:if>
            </footer>
          </article>
        </li>
        <li>
          <article>
            <h3 class="heading">For in the idea of chess </h3>
            <p>and the development of the chess mind we have a picture of</p>
            <p class="font-x1 uppercase bold">the intellectual struggle of mankind.</p>
            <footer>
              <c:if test="${sessionScope.CURRENT_USER==null}">
              <ul class="nospace inline pushright">
                <li><a class="btn" href="login.jsp">  LOGIN  </a></li>
                <li><a class="btn inverse" href="registrationForm.jsp">REGISTRY</a></li>
              </ul>
                </c:if>
            </footer>
          </article>
        </li>
      </ul>
    </div>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <section class="hoc container clear"> 
    <!-- ################################################################################################ -->
    <h6 class="heading">Let's join with us...</h6>
    <p class="nospace">The beauty of chess is it can be whatever you want it to be</p>
    <p class="nospace btmspace-80">It transcends language, age, race, religion, politics, gender, and socioeconomic background. </p>
    <div class="group latest">
        
        
        
        <c:forEach items="${requestScope.INFO}" var="contestDto" >
        
            <article class="one_third" style="margin-left: 150px; margin-top: 100px;">
              <figure><a href="#"><img src="img/coVua2.jpg" alt=""></a>
                <figcaption>
                  <time datetime="2045-04-06T08:15+00:00"><strong>06</strong> <em>Apr</em></time>
                </figcaption>
              </figure>
              <div class="txtwrap">
                <h4 class="heading">${contestDto.contestID} - ${contestDto.contestName}</h4>
                <ul class="nospace meta">
                  <li>by <a href="#">Admin</a></li>
                  <li>in <a href="#">Category Name</a></li>
                </ul>
                <p>${contestDto.description}&hellip;</p>
                <footer><a href="MainController?action=loadDataContestInfo&txtContestId=${contestDto.contestID}">Read More &raquo;</a></footer>
              </div>
            </article>
        </c:forEach>
      
        
        
        
        
      
    </div>
    <!-- ################################################################################################ -->
  </section>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row4">
  <footer id="footer" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <div class="one_third first">
      <h6 class="heading">Chess club</h6>
      <nav>
        <ul class="nospace">
          <li><a href="#"><i class="fa fa-lg fa-home"></i></a></li>
          <li><a href="#">About</a></li>
          <li><a href="#">Contact</a></li>
          <li><a href="#">Terms</a></li>
          <li><a href="#">Privacy</a></li>
          <li><a href="#">Cookies</a></li>
          <li><a href="#">Disclaimer</a></li>
          <li><a href="#">Online Shop</a></li>
          <li><a href="#">Sitemap</a></li>
        </ul>
      </nav>
      <ul class="faico clear">
        <li><a class="faicon-facebook" href="#"><i class="fa fa-facebook"></i></a></li>
        <li><a class="faicon-twitter" href="#"><i class="fa fa-twitter"></i></a></li>
        <li><a class="faicon-dribble" href="#"><i class="fa fa-dribbble"></i></a></li>
        <li><a class="faicon-linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
        <li><a class="faicon-google-plus" href="#"><i class="fa fa-google-plus"></i></a></li>
        <li><a class="faicon-vk" href="#"><i class="fa fa-vk"></i></a></li>
      </ul>
    </div>
    <div class="one_third">
      <h6 class="heading">Aenean molestie velit</h6>
      <ul class="nospace linklist contact">
        <li><i class="fa fa-map-marker"></i>
          <address>
          Street Name &amp; Number, Town, Postcode/Zip
          </address>
        </li>
        <li><i class="fa fa-phone"></i> +00 (123) 456 7890</li>
        <li><i class="fa fa-envelope-o"></i> info@domain.com</li>
      </ul>
    </div>
    <div class="one_third">
      <h6 class="heading">Aliquam sit condimentum</h6>
      <form method="post" action="#">
        <fieldset>
          <legend>Newsletter:</legend>
          <input class="btmspace-15" type="text" value="" placeholder="Name">
          <input class="btmspace-15" type="text" value="" placeholder="Email">
          <button type="submit" value="submit">Submit</button>
        </fieldset>
      </form>
    </div>
    <!-- ################################################################################################ -->
  </footer>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row5">
  <div id="copyright" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <p class="fl_left">Copyright &copy; 2016 - All Rights Reserved - <a href="#">Domain Name</a></p>
    <p class="fl_right">Template by <a target="_blank" href="http://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
<!-- JAVASCRIPTS -->
<script src="layout/scripts/jquery.min.js"></script>
<script src="layout/scripts/jquery.backtotop.js"></script>
<script src="layout/scripts/jquery.mobilemenu.js"></script>
<script src="layout/scripts/jquery.flexslider-min.js"></script>
</body>
</html>