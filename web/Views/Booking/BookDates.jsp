<%-- 
    Document   : BookDates
    Created on : Apr 21, 2016, 1:39:09 AM
    Author     : shrankhla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../common/newheader.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select you Check in and Check Out Dates</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Hotel Booking Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //For-Mobile-Apps -->

<!-- Style --> <link rel="stylesheet" href="${pageContext.request.contextPath}/NewStatic/css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/NewStatic/css/jquery-ui.css" />
<!-- JavaScript --> <script type="text/javascript" src="${pageContext.request.contextPath}/NewStatic/js/jquery.min.js"></script>

        
        
        
        
        
    </head>
    <body>
        
        <h1 class="book">ASS Hotel Booking</h1>

<div class="reg">

		<h1>Book Your Suite!</h1>

                 <form action="${pageContext.request.contextPath}/MakePayment" method="get">
                
		<div class="members">
			<div class="adult">
				<h2>No. of Adults</h2>
					<div class="dropdown-button">           			
				    	<select class="dropdown" tabindex="10" data-settings='{"wrapperClass":"flat"}'>
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
						</select>
					</div>
			</div>

			<div class="child">
				<h2>No. of Children</h2>
					<div class="dropdown-button">         			
			    		<select class="dropdown" tabindex="10" data-settings='{"wrapperClass":"flat"}'>
							<option value="">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
			</div>
		<div class="clear"></div>
		</div>

		<div class="suite">
			<div class="dropdown-button">
				<h2>Suite</h2>           			
    			<select class="dropdown" tabindex="10" data-settings='{"wrapperClass":"flat"}'>
					<option value="1">-</option>
					<option value="1">Single Room</option>
					<option value="2">Premium Single Room</option>
					<option value="2">Double Room</option>
					<option value="2">Premium Double Room</option>
					<option value="3">Deluxe Suite</option>
					<option value="4">Executive Suite</option>
					<option value="4">Ocean View Suite</option>
					<option value="4">Presidential Suite</option>
					<option value="3">The Penthouse</option>
				</select>
			</div>
		</div>

		<div class="book-pag">
			<h2>Select Date</h2>
			<div class="book-pag-frm1">
				<label>Check In</label>
				<input class="date" id="datepicker1" type="text" value="Date" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required="">
			</div>
			<div class="book-pag-frm2">
				<label>Check Out</label>
				<input class="date" id="datepicker2" type="text" value="Date" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required="">
			</div>
		<div class="clear"></div>
		</div>	

		<!--Date Picker-->
			
			<script src="js/jquery-ui.js"></script>
					  <script>
							  $(function() {
							    $( "#datepicker,#datepicker1,#datepicker2" ).datepicker();
							  });
					  </script>
		<!--//Date Picker-->

		<div class="rs">					
				<div class="check_box"> <div class="radio"> <label><input type="checkbox" name="radio" checked=""><i></i>Enable Room Service</label> </div></div>
		</div>

		<div class="food">
			<h2>Choose Cuisine</h2>
				<div class="radio-btns">						
					<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio" checked=""><i></i>Local</label> </div></div>
		            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Multi</label> </div></div>    
				</div>
		</div>

		<div class="submit">
				<input type="submit" class="book" value="BOOK NOW">
		</div>

                 </form>
</div>

<div class="reg-footer">
     <p>Copyright &copy; 2015 Hotel Booking Widget. All Rights Reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
</div>
        
        
        
    </body>
</html>

<%@ include file="../common/newfooter.jsp"%>