<%-- 
    Document   : mainview
    Created on : 1 Apr, 2016, 1:02:31 AM
    Author     : aksharma2
--%>

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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
<link href="../../static/css/style.css" rel="stylesheet" type="text/css" media="all" />

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<script src="../../static/js/jquery.min.js"></script>
<!--start slider -->
<link rel="stylesheet" href="../../static/css/fwslider.css" media="all">
<script src="../../static/js/jquery-ui.min.js"></script>
<script src="../../static/js/css3-mediaqueries.js"></script>
<script src="../../static/js/fwslider.js"></script>
<!--end slider -->
<!---strat-date-piker---->
<link rel="stylesheet" href="../../static/css/jquery-ui.css" />
<script src="../../static/js/jquery-ui.js"></script>
		  <script>
				  $(function() {
				    $( "#datepicker,#datepicker1" ).datepicker();
				  });
		  </script>
<!---/End-date-piker---->
<link type="text/css" rel="stylesheet" href="../../static/css/JFGrid.css" />
<link type="text/css" rel="stylesheet" href="../../static/css/JFFormStyle-1.css" />
		<script type="text/javascript" src="../../static/js/JFCore.js"></script>
		<script type="text/javascript" src="../../static/js/JFForms.js"></script>
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
			<a href="index.html"><img src="../../static/img/logo.png" width="159px" height="45px" alt=""></a>
		</div>
		<div class="h_right">
			<!--start menu -->
			<ul class="menu">
				<li class="active"><a href="hotelmgmt.jsp">View hotels</a></li> |
				<li><a href="account.jsp">rooms & suits</a></li> |
				<li><a href="reservation.html">reservation</a></li> |
				<li><a href="contact.html">contact</a></li> |
                                <li><a href="login.jsp">Login</a></li> 
					
				<div class="clear"></div>
			</ul>
			<!-- start profile_details -->
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
		</div>
		<div class="clear"></div>
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
	</div>
</div>
</div>
<!----start-img-slider---->
		<div class="img-slider">
			<!-- start slider -->
		    <div id="fwslider">
		        <div class="slider_container">
		            <div class="slide"> 
		                <!-- Slide image -->
		                    <img src="../../static/img/slider-bg.jpg" alt=""/>
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
		                <img src="../../static/img/slider-bg.jpg" alt=""/>
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
	<!--start grids_of_3 -->
        
         <form action="${pageContext.request.contextPath}/ViewHotel" method="post">
        
	<div class="grids_of_3">
		<div class="grid1_of_3">
			<div class="grid1_of_3_img">
				<!--<a href="${pageContext.request.contextPath}/ViewHotel?hotelchosen=london"> -->
					<img src="../../static/img/pic2.jpg" alt="" />
                                        <span class="next"> </span>
			
			</div>
			<h4><a href="#"><span>London</span></a></h4>
			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
                         <button type="submit" class="btn btn-success" name="hotelchosen" value="london"> BOOK NOW </button>
                                              
                                
                </div>
		<div class="grid1_of_3">
			<div class="grid1_of_3_img">
				<!--a href="${pageContext.request.contextPath}/ViewHotel?hotelchosen=hk"-->
					<img src="../../static/img/pic1.jpg" alt="" />
					<span class="next"> </span>
				
			</div>
			<h4><a href="#"><span>Hong Kong</span></a></h4>
			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
                        <button type="submit" class="btn btn-success" name="hotelchosen" value="hk"> BOOK NOW </button>
                          
                </div>
		<div class="grid1_of_3">
			<div class="grid1_of_3_img">
				<!--a href="${pageContext.request.contextPath}/ViewHotel?hotelchosen=ny" -->
					<img src="../../static/img/pic3.jpg" alt="" />
					<span class="next"> </span>
				
			</div>
			<h4><a href="#"><span>New York</span></a></h4>
			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
                        <button type="submit" class="btn btn-success" name="hotelchosen" value="ny"> BOOK NOW </button>
                          
                </div>
		
		<div class="grids_of_3">
		<div class="grid2_of_3">
			<div class="grid2_of_3_img">
				<!--a href="${pageContext.request.contextPath}/ViewHotel?hotelchosen=paris" -->
					<img src="../../static/img/pic3.jpg" alt="" />
					<span class="next"> </span>
			
			</div>
			<h4><a href="#"><span>Paris</span></a></h4>
			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
                        <button type="submit" class="btn btn-success" name="hotelchosen" value="paris"> BOOK NOW </button>
                          
                </div>

		<div class="grid2_of_3">
			<div class="grid2_of_3_img">
				<!--a href="${pageContext.request.contextPath}/ViewHotel?hotelchosen=tokyo" -->
					<img src="../../static/img/pic3.jpg" alt="" />
					<span class="next"> </span>
				
			</div>
			<h4><a href="#"><span>Tokyo</span></a></h4>
			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
                        <button type="submit" class="btn btn-success" name="hotelchosen" value="tokyo"> BOOK NOW </button>
                          
                </div>


		<div class="grid2_of_3">
			<div class="grid2_of_3_img">
				<!--a href="${pageContext.request.contextPath}/ViewHotel?hotelchosen=vancouver" -->
					<img src="../../static/img/pic3.jpg" alt="" />
					<span class="next"> </span>
				
			</div>
			<h4><a href="#"><span>Vancouver</span></a></h4>
			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
                        <button type="submit" class="btn btn-success" name="vancouver" value="london"> BOOK NOW </button>
                          
                </div>
			
                                        </form>

		<div class="clear"></div>
	</div>	
</div>
</div>		
<!--start main -->
<div class="footer_bg">
<div class="wrap">
<div class="footer">
			<div class="copy">
				<p class="link"><span>� All rights reserved | Paradise Booking Co. </span></p>
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
