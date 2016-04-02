

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jspf"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ASS Hotel Booking</title>
        <meta charset="utf-8">
         <meta name="viewport" content="width=device-width, initial-scale=1">
         <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
         <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
       
       
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
        
        <div class="jumbotron text-center">
        <h1>ASS Booking Website</h1>
        <p>We specialize in Hotel Booking</p>
        <form class="form-inline">
    <input type="email" class="form-control" size="50" placeholder="Email Address">
    <button type="button" class="btn btn-danger">Subscribe</button>
  </form>
        
         <div class="container">
  <h2>Make Your Bookings</h2>
  
  <form role="form" method="post" action="MakeMyBooking">
      
    <div class="form-group">
        <h2>Select the Hotel you want to choose</h2>
        <h2> <span class="label label-success">Hotel:</span></h2><br>
      <select name="hotels" class="form-control">
       <option value="hyatt">Hyatt</option>
       <option value="radisson">Radisson</option>
       <option value="itc">ITC</option>
       <option value="leela">Leela Palace</option>
            </select>
      
    </div>
      
    <div class="form-group">
        <h2>Select the Room Size </h2><br>
        <h2><span class="label label-danger">Room:</span></h2>
      <select name="rooms" class="form-control"> 
                       <option value="single">Single</option>
                        <option value="deluxe">Deluxe</option>
                        <option value="suite">Suite</option>
                        <option value="prsuite">Presidential Suite</option>
                      </select>
    </div>
      <br>
      <br>
      <div class="form-group">
    <input type= "submit" class="btn btn-info" value='Make Booking!' />
        </form>
      </div>
        
      <div class="container-fluid text-center bg-grey">
  <h2>Our Top Class Hotels</h2><br>
  
  <div class="row text-center">
    <div class="col-sm-4">
      <div class="thumbnail">
        <img src="http://quartier-latin.education/images/paris.jpg" alt="Paris" width="400" height="300">
        <p><strong>Paris</strong></p>
         <p>5 Star Hotels Available</p>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="thumbnail">
        <img src="http://www.newyorker.com/wp-content/uploads/2015/12/Veix-Goodbye-New-York-Color-1200.jpg" alt="New York" width="400" height="300">
        <p><strong>New York</strong></p>
         <p>7 Star Hotels Available</p>
       
      </div>
    </div>
    <div class="col-sm-4">
      <div class="thumbnail">
        <img src="http://www.nextstepconnections.com/wp/wp-content/uploads/2016/02/pictures.4ever.eu-hong-kong-159071.jpg" alt="San Francisco" width="400" height="300">
        <p><strong>Hong Kong</strong></p>
         <p>10 Star Hotels Available</p>
      </div>
    </div>
  </div>
</div>

    <div class="container-fluid">
  <div class="text-center">
    <h2>Pricing</h2>
    <h4>Choose a payment plan that works for you</h4>
  </div>
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>Basic: Single Room</h1>
        </div>
        <div class="panel-body">
            <p><strong>Our Single Rooms are the perfect combination of comfort and function</strong></p>
          <p><strong>Size 230 Sq Ft</strong></p>
          <p><strong>Bed: 1 Double</strong></p>
          
        </div>
        <div class="panel-footer">
          <h3>$150</h3>
          <h4>per day</h4>
          <button class="btn btn-lg">Sign Up</button>
        </div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>Deluxe</h1>
        </div>
        <div class="panel-body">
            <p><strong>Our Deluxe Rooms provide double beds and attached kitchen</strong></p>
          <p><strong>Size 270 Sq Ft</strong></p>
          <p><strong>Bed 2 Double</strong></p>
        </div>
        <div class="panel-footer">
          <h3>$199</h3>
          <h4>per day</h4>
          <button class="btn btn-lg">Sign Up</button>
        </div>
      </div>
    </div>
   <div class="col-sm-4">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>Junior Suite</h1>
        </div>
        <div class="panel-body">
            <p><strong>Our Junior Suite offer Breathtaking views of the Skyline</strong></p>
          <p><strong>Size 370 Sq Ft</strong></p>
          <p><strong>Bed 2 King Size Double Beds</strong></p>
        </div>
        <div class="panel-footer">
          <h3>$289</h3>
          <h4>per day</h4>
          <button class="btn btn-lg">Sign Up</button>
          
        </div>
      </div>
    </div>
      
  </div>
</div>  
   
  </body>
</html>
        
     
   

<%--end content--%>
<%@ include file="../common/footer.jspf"%>