<%-- 
    Document   : Payment
    Created on : Apr 7, 2016, 1:15:46 AM
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
        <title>Hotel Checkout Form</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Hotel Checkout Form Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="${pageContext.request.contextPath}/myStatic/css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath}/myStatic/js/jquery.min.js"></script>
<link href='//fonts.googleapis.com/css?family=Droid+Serif:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
 

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
  <style>
      
      
      .ni {
         
      }
      
      
  </style>
  
  
  <!-- script for close -->
<script>
$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.vlcone').fadeOut('slow', function(c){
			$('.vlcone').remove();
		});
	});	
        
   var x = ":$ " (500 + (${requestScope.tariff}));

 

$('#detailslist li').click(function() {
     //Get the id of list items
     $(this).text(x)
     
   });     
        
});







    





</script>
  
  
    </head>
    
    
    <!--form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/AssignRoom" method="post" -->
  
    <!--
    <body>
        <h1>You have selected the RoomType : 
        ${requestScope.roomType}</h1>
        
        <h1> Please Pay : ${requestScope.tariff} Amount </h1>
        
            
          <div class="container">
              <h1>Guest Details </h1>
              
  
    <div class="form-group">
      <label class="control-label col-sm-2" for="firstname">Guest First Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="firstname" placeholder="Enter First Name" required="required">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="lastname">Guest Last Name:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="lastname" placeholder="Enter Last Name" required="required">
      </div>
    </div>
    
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="HotelName">Hotel:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="HotelName" value="${requestScope.HotlName}">
      </div>
    </div>
    
    
    
     
     <div class="form-group">
      <label class="control-label col-sm-2" for="passport">Country of Passport:</label>
      <div class="col-sm-10">
      <select class="form-control" id="passport" required="required">
        <option>CH:Switzerland</option>
        <option>GB:United Kingdom</option>
        <option>US:United States</option>
        <option>TH:Thailand</option>
        <option>SG:Singapore</option>
        <option>MY:Malaysia</option>
        <option>KP:Korea, Democratic People's Republic of</option>
        <option>HK:Hong Kong</option>
        <option>IN:India</option>
        
      </select>
      </div>
     </div>
    
    <h1>Billing Details</h1>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="paymethod"> Payment Method</label>
      <div class="col-sm-10">
      <select class="form-control" id="paymethod" required="required">
        <option>Visa</option>
        <option>Master Card</option>
        <option>American Express</option>
        <option>PayPal</option>
        <option>JCB</option>
      
      </select>
    </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="cardnum">Card Number:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="cardnum" placeholder="Enter Credit Card Num" required="required">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="cardname">Card Holder Name:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="cardname" placeholder="Enter Card Holder Name" required="required">
      </div>
    </div>
    
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="expdate">Expiry Date</label>
      <div class="col-sm-10">
      <select class="form-control" id="expdate" required="required">
        <option value=''>Month</option>
    <option value='01'>Janaury</option>
    <option value='02'>February</option>
    <option value='03'>March</option>
    <option value='04'>April</option>
    <option value='05'>May</option>
    <option value='06'>June</option>
    <option value='07'>July</option>
    <option value='08'>August</option>
    <option value='09'>September</option>
    <option value='10'>October</option>
    <option value='11'>November</option>
    <option value='12'>December</option>
      
      </select>
      
    <select class="form-control" id="expdatem" required="required">
        <option value=''>Year</option>
        <option value='10'>2010</option>
        <option value='11'>2011</option>
        <option value='12'>2012</option>
         
      </select>
    </div>
    </div>
    
     <div class="form-group">
      <label class="control-label col-sm-2" for="cvv">CVV Number:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="CVV" required="required">
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default" >Submit</button>
      </div>
    </div>
  </form>
</div>
   
             
    
    </body>
    
    -->
    
    <body>
<div class="main">
	<h1>HOTEL CHECKOUT FORM : ${requestScope.HotlName}</h1>
	
	<div class="hotel-right  vlcone">
		<div class="alert-close"> </div>
		<div class="hotel-form">
			<h3>Receipt Form</h3>
			<ul class="list_ins1">
                                                
						<li>Room No.</li>
						<li>Room Charges</li>
						<li>Services Charges</li>
						<li>Vat</li>
						<li>Total</li>
			</ul>
			<ul class="list_ins2" id="detailslist">
                                                
						<li>: $201</li>
						<li>: $ ${requestScope.tariff}</li>
						<li>: $10.00</li>
						<li>: $0.00</li>
						<li>510</li>
			</ul>
			<div class="clear"></div>
		</div>
		<div class="pay-form">
			<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/AssignRoom" method="post">
				<h3>Payment Information</h3>
				<h5>Name On Credit Card</h5>
				
                  <input type="text"  value="James Thompson" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'James Thompson';}" required="">

                          
                            
 
                              
				<h5>Credit Card Number</h5>
				<input class="card_logo" type="text" value="2525 2525 2525 2525" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '2525 2525 2525 2525';}" required="">

				<h5>Expires On</h5>
				<select id="country" onchange="change_country(this.value)" class="frm-field required">
					<option value="null">January</option>
					<option value="null">February</option>         
					<option value="AX">March</option>
					<option value="AX">April</option>
					<option value="AX">May</option>
					<option value="AX">June</option>
					<option value="AX">July</option>
					<option value="AX">August</option>
					<option value="AX">September</option>
					<option value="AX">October</option>
					<option value="AX">November</option>
					<option value="AX">December</option>
				</select>
				<ul>
					<li>
						<input type="number" class="text_box" type="text" value="1988" min="1" />	
					</li>
				</ul>
				<div class="clear"></div>
				<h5>CVC</h5>
				<input type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required="">

				<input type="submit" value="BOOK SECURELY">
			</form>
			<p><span></span>Your credit card information is encrypted.</p>
		</div>
	</div>
	<div class="hotel-left">
		<div class="hotel-text">
			<h2>ROYAL PALACE</h2>
			<h3> $250.00 / <span>night</span></h3>
			<p>Entire Room for 5 members.</p>
			<p>Thursday, Dec 10, 2014 to Thursday, Dec 12, 2014.</p>
		</div>
	</div>
	<div class="clear"></div>
	<p class="footer">&copy; 2015 Hotel Checkout Form. All Rights Reserved | Design by <a href="http://w3layouts.com/"> W3layouts</a></p>
</div>
</body>
  
    
    
    
    
    
    
    
    
</html>

<%@ include file="../common/newfooter.jsp"%>