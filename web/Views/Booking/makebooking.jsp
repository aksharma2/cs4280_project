

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
       </head>
    <body>
        
       <div class="container">
  <h2>Make Your Bookings</h2>
  <form role="form" method="post" action="MakeMyBooking">
      
    <div class="form-group">
        <h2>Select the Hotel you want to choose</h2>
      <label for="hotel">Hotel:</label>
      <select name="hotels" class="form-control">
       <option value="hyatt">Hyatt</option>
       <option value="radisson">Radisson</option>
       <option value="itc">ITC</option>
       <option value="leela">Leela Palace</option>
            </select>
      
    </div>
      
    <div class="form-group">
        <h2>Select the Room Size </h2>
      <label for="room">Room:</label>
      <select name="rooms" class="form-control"> 
                       <option value="single">Single</option>
                        <option value="deluxe">Deluxe</option>
                        <option value="suite">Suite</option>
                        <option value="prsuite">Presidential Suite</option>
                      </select>
    </div>
    
      <div class="form-group">
    <input type= "submit" class="form-control" value='Make Booking!' />
        </form>
      </div>


    </body>
</html>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>