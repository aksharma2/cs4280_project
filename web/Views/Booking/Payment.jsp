<%-- 
    Document   : Payment
    Created on : Apr 7, 2016, 1:15:46 AM
    Author     : shrankhla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <title>Please Pay Here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    
    <body>
        <h1>You have selected the RoomType : 
        ${requestScope.roomType}</h1>
        
        <h1> Please Pay : ${requestScope.tariff} Amount </h1>
        
            
          <div class="container">
              <h1>Guest Details </h1>
              
  
  <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/AssignRoom" method="post" >
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
</html>
