<%-- 
    Document   : hotelmgmt
    Created on : 4 Apr, 2016, 2:49:33 AM
    Author     : aksharma2
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../common/header.jspf"%>
<%@ include file="../common/sidebar.jspf"%>
<%@page import="hotelBooking.core.domain.Hotel"%>
<%@page import="hotelBooking.core.jdbc.HotelDBHandler"%>
<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Test hotels!</h1>
      
       
       <form action="${pageContext.request.contextPath}/ViewHotel" method="post">
            
            Input<input type="text" value="Enter text" name="id">
            City<input type = "radio" name = "Q2" value="city" checked="checked">
            Id<input type = "radio" name = "Q2" value="id">
            All Hotels<input type = "radio" name = "Q2" value="allHotels">
            <input type="submit" value="submit">
           
        </form>
        
       <table class="table table-bordered table-striped">

                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Hotel Images</th>
                        
                    </tr>
                    </thead>
           
          <tbody>
                    
         
           <% try{ List<Hotel> myList = (ArrayList<Hotel>) request.getAttribute("hotel"); %>
           
                            <% for (Hotel h:myList){ %>
                            <tr>
                            <td><%=h.getId() %></td> 
                            <td><%=h.getName() %></td>
                            <td><%=h.getCity() %></td>
                            
                            
                            <td> <% for(String s:h.getImg()){ %> 
                                  <img src=" <%= s %> " width=90 height=90>  
                            
                           <% } %></td> </tr>
                                
                                <% } %>   <% }catch(NullPointerException n){
                                        n.printStackTrace();
                                        }  %>
                                
                                
          
                           
                                
                                
                                
                                
                                   
                   
                            
                                
                                
                    
                    </tbody>
            </table>
       
        
                            
                            
                                
                        
                               
                                
                    
        
      
    </body> 
</html>
