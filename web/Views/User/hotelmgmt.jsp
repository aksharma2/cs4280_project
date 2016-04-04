<%-- 
    Document   : hotelmgmt
    Created on : 4 Apr, 2016, 2:49:33 AM
    Author     : aksharma2
--%>

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
                        
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${requestScope.hotel}" var="hot">
                        <tr>
                            <td>${hot.id}</td>
                            <td>${hot.name}</td>
                            <td>${hot.city}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
        </table>
       
        
       
      
    </body> 
</html>
