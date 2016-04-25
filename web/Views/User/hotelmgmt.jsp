<%-- 
    Document   : hotelmgmt
    Created on : 4 Apr, 2016, 2:49:33 AM
    Author     : aksharma2
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../common/newheader.jsp"%>

<%@ include file="../common/sidebar.jspf"%>
<%@page import="hotelBooking.core.domain.Hotel"%>
<%@page import="hotelBooking.core.jdbc.HotelDBHandler"%>
<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/form.css" />
         <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/hoteltable.css" />
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/sliderman.css" />
         <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.9.1.min.js"></script>
         <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<link rel="stylesheet" href="/resources/demos/style.css">
        <title>JSP Page</title>
    </head>
    <body>
        
        <script type="text/javascript">
            
            var imgArray = new Array();
            var i=0;
            
            <% try {List<Hotel> hList = (ArrayList<Hotel>)request.getAttribute("hotel"); 
            
            for(Hotel h:hList){
                
                for(String s:h.getImg()){ %>
                   
                   imgArray.push("<%=s %>");
                           
                <% } %>
                
            <% } }catch(NullPointerException n){
                                        n.printStackTrace();
                                        }  %>  
             
             
            
          function swapImage()
{
   document.imgslide.src = imgArray[i];
   if(i < imgArray.length - 1) i++; else i = 0;
   setTimeout("swapImage()",3000);
   
}

window.onload=swapImage;

           
            </script>
                                        
 <script>
	$(function() {
		$( "#slider-range" ).slider({
			range: true,
			min: 0,
			max: 10000,
			values: [ 75, 300 ],
			slide: function( event, ui ) {
				$( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
                                $(" #lower ").val(ui.values[0]);
                                 $("#upper ").val(ui.values[1]);
			}
		});
		$( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
			" - $" + $( "#slider-range" ).slider( "values", 1 ) );
	});
	</script>
        
        
        
        
        <h1>View hotels!</h1>
        
        <div class="testbox" style="height:450px">
  <h1>Input parameter</h1>

  <form action="${pageContext.request.contextPath}/ViewHotel" method="post">
      <hr>
    <div class="accounttype">
      <input type="radio" value="city" id="radioOne" name="Q2" checked/>
      <label for="radioOne" class="radio" chec>By City</label>
      <input type="radio" value="id" id="radioTwo" name="Q2" />
      <label for="radioTwo" class="radio">By id</label>
       <input type="radio" value="allHotels" id="radioThree" name="Q2" />
      <label for="radioThree" class="radio">All Hotels</label>
    </div>
  <hr>
  
  <input type="text" name="id" id="name" placeholder="Enter text" />
  
  <label for="amount">Price range:</label>
	<input type="text" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">
     
        <% try{ %>
        <div id="slider-range"></div>
        <input type="hidden" id="lower" name="lowerval">
        <input type="hidden" id="upper" name="upperval">
   
                <% }catch(NumberFormatException nfe){

}  %>
  
  
  <div class="gender">
    
   </div> 
  
   <input type="submit" value="submit">
  </form>
</div>
      
     
   


        
      <div class="box-table">  
       <table>

                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Hotel Images</th>
                        <th>Book Now</th>
                        
                    </tr>
                    </thead>
           
          <tbody>
                    
          <% try{ List<Hotel> myList = (ArrayList<Hotel>) request.getAttribute("hotel"); %>
                  
                            <% for (Hotel h:myList){ %>
                            <%! List<String> strList = new ArrayList<String>(); %>
                            
                            <tr>
                            <td><h3><%=h.getId() %></h3></td> 
                            <td><h3><%=h.getName() %></h3></td>
                            <td><h3><%=h.getCity() %></h3></td>
                            <td>
                            <% for(String s:h.getImg()){ %>
                            <img src =<%=s %> width="100px" height="100px"  > 
                            <% } %>
                            </td> 
                           <td>
                                <form action="${pageContext.request.contextPath}/BookMyRoom" method="get">
                                    
                                    <INPUT TYPE=hidden NAME="hotelN" VALUE="<%=h.getName() %>">
                                    <INPUT TYPE=hidden NAME="hotelC" VALUE="<%=h.getCity() %>">
                                    <INPUT TYPE=hidden NAME="HotelID" VALUE="<%=h.getId() %>">
                                    
                                    
                                    <% for(String s:h.getImg()){ %> 
                                 
                                        <INPUT TYPE=hidden NAME="hotelU" VALUE=" <%= s %>">
                                      
                                    <% } %>
                                    
                                   <button type="submit" class="btn btn-warning">BOOK NOW!</button>
                                </form>
                              
                            </td>
          </tr>
                                
                                <% } %>   <% }catch(NullPointerException n){
                                        n.printStackTrace();
                                        }  %>
                                
                                
          
                           
                                
                                
                                
                                
                                   
                   
                            
                                
                                
                    
                    </tbody>
            </table>
      </div>
       
    
        
                            
                            
                                
                        
                               
                                
                    
        
      
    </body> 
</html>
