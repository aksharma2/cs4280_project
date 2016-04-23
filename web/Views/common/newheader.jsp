<%-- 
    Document   : newheader
    Created on : 10 Apr, 2016, 9:16:12 PM
    Author     : aksharma2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Paradise-Hotel Website Template | Hotel :: w3layouts</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<!--start slider -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/fwslider.css" media="all">
<script src="../../static/js/jquery-ui.min.js"></script>
<script src="../../static/js/css3-mediaqueries.js"></script>
<script src="../../static/js/fwslider.js"></script>
<!--end slider -->
<!---strat-date-piker---->
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery-ui.css" />
<script src="../../static/js/jquery-ui.js"></script>
		  <script>
				  $(function() {
				    $( "#datepicker,#datepicker1" ).datepicker();
				  });
		  </script>
<!---/End-date-piker---->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/JFGrid.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/JFFormStyle-1.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/JFCore.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/JFForms.js"></script>
		<!-- Set here the key for your domain in order to hide the watermark on the web server -->
		<script type="text/javascript">
			(function() {
				JC.init({
					domainKey: ''
				});
				})();
		</script>
<!--nav-->
<script>
		$(function() {
			var pull 		= $('#pull');
				menu 		= $('nav ul');
				menuHeight	= menu.height();

			$(pull).on('click', function(e) {
				e.preventDefault();
				menu.slideToggle();
			});

			$(window).resize(function(){
        		var w = $(window).width();
        		if(w > 320 && menu.is(':hidden')) {
        			menu.removeAttr('style');
        		}
    		});
		});
</script>
</head>
<body>
<!-- start header -->
<div class="header_bg">
<div class="wrap">
	<div class="header">
		<div class="logo">
			<a href="index.html"><img src="${pageContext.request.contextPath}/static/img/logo.png" width="159px" height="45px" alt=""></a>
		</div>
		<div class="h_right">
			<!--start menu -->
			<ul class="menu">
				<li class="active"><a href="${pageContext.request.contextPath}/Views/User/hotelmgmt.jsp">View hotels</a></li> |
				<li><a href="${pageContext.request.contextPath}/Views/User/account.jsp">rooms & suits</a></li> |
				<li><a href="${pageContext.request.contextPath}/Views/User/register.jsp">reservation</a></li> |
				<li><a href="${pageContext.request.contextPath}/Views/User/contact.html">contact</a></li> |
                                
                                
                                <c:if test="${sessionScope.user != null}">
                                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Welcome ${sessionScope.user.name}</a></li> |
                                    <li><a href="${pageContext.request.contextPath}/user/logout"><span class="glyphicon glyphicon-log-out"></span> Log Out </a></li>
                                </c:if>
                                <c:if test="${sessionScope.user == null}">
                                  <li><a href="${pageContext.request.contextPath}/user/register?referer=${pageContext.request.requestURI}">Register</a></li> |
                                  <li><a href="${pageContext.request.contextPath}/user/login?referer=${pageContext.request.requestURI}">Login</a></li>
                                </c:if>
					
				<div class="clear"></div>
			</ul>
			
		</div>
		<div class="clear"></div>
		<div class="top-nav">
		<nav class="clearfix">
				<ul>
				<li class="active"><a href="${pageContext.request.contextPath}/Views/User/index.html">hotel</a></li> 
				<li><a href="${pageContext.request.contextPath}/Views/User/rooms.html">rooms & suits</a></li> 
				<li><a href="${pageContext.request.contextPath}/Views/User/reservation.html">reservation</a></li> 
				<li><a href="${pageContext.request.contextPath}/Views/User/activities.html">activities</a></li> 
				<li><a href="${pageContext.request.contextPath}/Views/User/contact.html">contact</a></li>
				</ul>
				<a href="#" id="pull">Menu</a>
			</nav>
		</div>
	</div>
</div>
</div>
</html>
