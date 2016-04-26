<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../common/newheader.jsp"%>

<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>


<html>
<head>
<title>The Paradise-Hotel Website Template | Hotel :: w3layouts</title>

<meta charset="utf-8">
         <meta name="viewport" content="width=device-width, initial-scale=1">
         <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
         <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
       


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<!--start slider -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/fwslider.css" media="all">
<script src="${pageContext.request.contextPath}/static/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/css3-mediaqueries.js"></script>
<script src="${pageContext.request.contextPath}/static/js/fwslider.js"></script>
<!--end slider -->
<!---strat-date-piker---->
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery-ui.css" />
<script src="${pageContext.request.contextPath}/static/js/jquery-ui.js"></script>
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
 <style>
.jumbotron {
    background-color: #f4511e; /* Orange */
    color: #ffffff;
}
.thumbnail {
    padding: 0 0 15px 0;
    border: none;
    border-radius: 0;
}

.thumbnail img {
    width: 100%;
    height: 100%;
    margin-bottom: 10px;
}
.panel {
    border: 1px solid #f4511e;
    border-radius:0;
    transition: box-shadow 0.5s;
}

.panel-body{
    color: black;
    
}

.bg-1 { 
      background-color: #1abc9c; /* Green */
      color: #ffffff;
  }
.panel:hover {
    box-shadow: 5px 0px 40px rgba(0,0,0, .2);
}

.panel-footer .btn:hover {
    border: 1px solid #f4511e;
    background-color: #fff !important;
    color: #f4511e;
}

.panel-heading {
    color: #fff !important;
    background-color: #f4511e !important;
    padding: 25px;
    border-bottom: 1px solid transparent;
    border-top-left-radius: 0px;
    border-top-right-radius: 0px;
    border-bottom-left-radius: 0px;
    border-bottom-right-radius: 0px;
}



.panel-footer {
    background-color: #fff !important;
    color:black;
}

.panel-footer h3 {
    font-size: 32px;
}

.panel-footer h4 {
    color: #aaa;
    font-size: 14px;
}

.panel-footer .btn {
    margin: 15px 0;
    background-color: #f4511e;
    color: #fff;
}

</style>


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
	                		
               
                
		
               <!--
			
			<ul class="menu">
				<li class="active"><a href="${pageContext.request.contextPath}/index.jsp">hotel</a></li> 
                                    <li><a href="./Views/User/account.jsp">rooms & suits</a></li> 
				<li><a href="reservation.html">reservation</a></li> 
				<li><a href="contact.html">contact</a></li> 
                                <li><a href="login.jsp">Login</a></li> 
				
                                <div class="clear"></div>
				
			</ul> -->
			
               <!--
               
               
					<form class="style-1 drp_dwn">
						<div class="row">
							<div class="grid_3 columns">
								<select class="custom-select" id="select-1">
									<option id="hide" selected="selected">Welcome user xxxxxxxx</option>
                                                                        
                                                                       <option>Log out</option>
									
								</select>
							</div>		
						</div>		
					</form>
               -->
               
               
		</div>
		<div class="clear"></div>
                
                <!--
                
                <div class="top-nav">
		
                    <nav class="clearfix">
				<ul>
				<li class="active"><a href="index.html">hotel</a></li> 
				<li><a href="rooms.html">rooms & suits</a></li> 
				<li><a href="reservation.html">reservation</a></li> 
				<li><a href="activities.html">activities</a></li> 
				<li><a href="contact.html">contact</a></li>
				</ul>
				<a href="#" id="pull">Menu</a>
			</nav>
                
		</div>
                
                
                -->
	</div>
</div>
</div>
<!----start-img-slider---->


<!----start-img-slider---->
		<div class="img-slider">
			<!-- start slider -->
		    <div id="fwslider">
		        <div class="slider_container">
		            <div class="slide"> 
		                <!-- Slide image -->
		                    <img src="${pageContext.request.contextPath}/static/img/slider-bg.jpg" alt=""/>
		                <!-- /Slide image -->
		                <!-- Texts container -->
		                <div class="slide_content">
		                    <div class="slide_content_wrap">
		                        <!-- Text title -->
		                        <h4 class="title"><i class="bg"></i>Lorem Ipsum is simply <span class="hide">dummy text</span></h4>
		                        <h5 class="title1"><i class="bg"></i>Morbi justo <span class="hide" >condimentum accumsan</span></h5>
		                        <!-- /Text title -->
		                    </div>
		                </div>
		                 <!-- /Texts container -->
		            </div>
		            <!-- /Duplicate to create more slides -->
		            <div class="slide">
		                <img src="${pageContext.request.contextPath}/static/img/slider-bg.jpg" alt=""/>
		                <div class="slide_content">
		                     <div class="slide_content_wrap">
		                        <!-- Text title -->
		                        <h4 class="title"><i class="bg"></i>Morbi justo <span class="hide"> condimentum </span>text</h4>
		                        <h5 class="title1"><i class="bg"></i>Lorem Ipsum is <span class="hide">simply dummy text</span> </h5>
		                        <!-- /Text title -->
		                    </div>
		                </div>
		            </div>
		            <!--/slide -->
		        </div>
		        <div class="timers"> </div>
		        <div class="slidePrev"><span> </span></div>
		        <div class="slideNext"><span> </span></div>
		    </div>
		    <!--/slider -->
		</div>

		
<!--start main -->
<div class="main_bg">
<div class="wrap">
	
				<div class="clear"></div>
			</ul>
		</div>
		<div class="clear"></div>
		</div>
	</div>
        
        
        
     <!--
        <div class="img-slider">
			
		    <div id="fwslider">
		        <div class="slider_container">
		            <div class="slide"> 
		               
                                <h1>${requestScope.hname}</h1>
                                <h1>${requestScope.hcity}</h1>
                                
                                <img src="${requestScope.hurl}" alt=""/>
                            </div>
                        </div>
                    </div>
      </div>
                                
       --> 
        
        
	<!--start grids_of_3 -->
	<div class="grids_of_3">
		<div class="grid1_of_3">
			<div class="grid1_of_3_img">
				<a href="details.html">
					<img src="${pageContext.request.contextPath}/static/img/pic2.jpg" alt="" />
					<span class="next"> </span>
				</a>
			</div>
                    
                  <form action="${pageContext.request.contextPath}/MakePayment" method="get">
                    
                    <div class="panel-heading">
			<h4><a href="#"><span>Basic:Single Room</span></a></h4>
                    </div>
                     <div class="panel-body">
                         <h3><strong><b>Our Single Rooms are the perfect combination of comfort and function</b></strong></h3>
                         <h3><strong>Size 230 Sq Ft</strong></h3>
                        <h3> <strong>Bed: 1 Double</strong></h3>
                         </div>
                          <div class="panel-footer">
                        
                        <c:if test="${requestScope.isAuthenticated}">
                            <h3><strike>${requestScope.singlePrice} $</strike> ${requestScope.singlePriceDisc} $</h3>
                            <input type="hidden" name="tariff" value="${requestScope.singlePriceDisc}"> 
                        </c:if>
                        <c:if test="${not requestScope.isAuthenticated}">
                            <h3>${requestScope.singlePrice} $</h3>
                            <input type="hidden" name="tariff" value="${requestScope.singlePrice}"> 
                        </c:if>
                            
                        <h3>per day</h3>
                        <p><h3 style="color: red">Rooms Available: ${requestScope.singleCount}</h3></p> 
                       <button type="submit" class="btn btn-warning" name="act" value="single">SELECT ROOM</button>
                        <input type="hidden" name="hotlName" value="${requestScope.hname}"> 
                        
                        </form>
                          
                          </div>
			</div>
		<div class="grid1_of_3">
			<div class="grid1_of_3_img">
				<a href="details.html">
					<img src="${pageContext.request.contextPath}/static/img/pic1.jpg" alt="" />
					<span class="next"> </span>
				</a>
			</div>
                                        
                         <form action="${pageContext.request.contextPath}/MakePayment" method="get">                 
                                        
                    <div class="panel-heading">
			<h4><a href="#"><span>Deluxe</span></a></h4>
                    </div>
                     <div class="panel-body">
                         <h3><strong>Our Deluxe Rooms provide double beds and attached kitchen</strong></h3>
                         <h3><strong>Size 270 Sq Ft</strong></h3>
                         <h3><strong>Bed 2 Double</strong></h3>
                     </div>
                     <div class="panel-footer">
                        <c:if test="${requestScope.isAuthenticated}">
                            <h3><strike>${requestScope.deluxePrice} $</strike> ${requestScope.deluxePriceDisc} $</h3>
                            <input type="hidden" name="tariff" value="${requestScope.deluxePriceDisc}"> 
                            
                        </c:if>
                        <c:if test="${not requestScope.isAuthenticated}">
                            <h3>${requestScope.deluxePrice} $</h3>
                            <input type="hidden" name="tariff" value="${requestScope.deluxePrice}"> 
                        </c:if>
                            
                        <h3>per day</h3>
                        <p><h3 style="color: red">Rooms Available: ${requestScope.deluxeCount}<h3></p>
                         <button type="submit" class="btn btn-warning" name="act" value="deluxe">SELECT ROOM</button>
                          <input type="hidden" name="hotlName" value="${requestScope.hname}">
                          
                          </form>
                     </div>
			</div>
                  
                  
		<div class="grid1_of_3">
			<div class="grid1_of_3_img">
				<a href="details.html">
					<img src="${pageContext.request.contextPath}/static/img/pic3.jpg" alt="" />
					<span class="next"> </span>
				</a>
			</div>
                                        
                         <form action="${pageContext.request.contextPath}/MakePayment" method="get">                 
                    <div class="panel-heading">
			<h4><a href="#"><span>Junior Suite</span></a></h4>
                    </div>
                     <div class="panel-body">
                         <h3><strong>Our Junior Suite offer Breathtaking views of the Skyline and Ocean</strong></h3>
                         <h3><strong>Size 370 Sq Ft</strong></h3>
                         <h3><strong>Bed 2 King Size Double Beds</strong></h3>
                        </div>
                        <div class="panel-footer">
                            <c:if test="${requestScope.isAuthenticated}">
                            <h3><strike>${requestScope.suiteePrice} $</strike> ${requestScope.suiteePriceDisc} $</h3>
                            <input type="hidden" name="tariff" value="${requestScope.suiteePriceDisc}"> 
                            </c:if>
                            <c:if test="${not requestScope.isAuthenticated}">
                                <h3>${requestScope.suiteePrice} $</h3>
                                <input type="hidden" name="tariff" value="${requestScope.suiteePrice}"> 
                            </c:if>
                                
                        <h3>per day</h3>
                        <p><h3 style="color: red">Rooms Available: ${requestScope.suiteeCount}</h3></p>
                         <button type="submit" class="btn btn-warning" name="act" value="suitee">SELECT ROOM</button>
                        <input type="hidden" name="hotlName" value="${requestScope.hname}">
                        
                         </form>
                        </div>
                        
             
                        
					</div>
                        
                        <div>
                            
                         
		
		
		<div class="clear"></div>
	</div>	
</div>
</div>		


    
<!--start main -->
<div class="footer_bg">
<div class="wrap">
<div class="footer">
			<div class="copy">
				<p class="link"><span>© All rights reserved | Paradise Booking Co. </span></p>
			</div>
			<div class="f_nav">
				<ul>
					<li><a href="#">home</a></li>
					<li><a href="reservation.html">reservation</a></li>
					<li><a href="contact.html">Contact</a></li>
				</ul>
			</div>
			<div class="soc_icons">
				<ul>
					<li><a class="icon1" href="#"></a></li>
					<li><a class="icon2" href="#"></a></li>
					<li><a class="icon3" href="#"></a></li>
					<li><a class="icon4" href="#"></a></li>
					<li><a class="icon5" href="#"></a></li>
					<div class="clear"></div>
				</ul>	
			</div>
			<div class="clear"></div>
</div>
</div>
</div>		
</body>
</html>

<%--end content--%>
<%@ include file="../common/newfooter.jsp"%>
