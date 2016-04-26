<%-- 
    Document   : allHotelBookings
    Created on : Apr 25, 2016, 12:44:21 AM
    Author     : shrankhla
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>s

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jspf"%>
<%-- <%@ include file="../common/sidebar.jspf"%> --%>
<%@ include file="../common/newheader.jsp"%>
<%@ page import="java.io.*,java.util.*" %>

<div class="container">
   
        
        <div class="span9">
            <div class="well">
                <div class="page-header">
                    <h1>View Your Bookings here</h1>
                </div>

                <%@ include file="../common/error.jspf"%>
                
                
                  <div>
            
           
            
        </div>
        
                
               
                
                <table class="table table-bordered table-striped">

                    <thead>
                    <tr>
                        <th> User ID </th>
                        <th>Hotel ID</th>
                        <th>Booking ID</th>
                        <th>City</th>
                        <th>User</th>
                        <th>Num of Rooms</th>
                        <th>Room Assigned</th>
                        <th>Edit Booking </th>
                        
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${requestScope.allHotelBookings}" var="booking">
                        <tr>
                            <td>${booking.userID}</td>
                            <td>${booking.hotelID}</td>
                            <td>${booking.bookingID}</td>
                            <td>${booking.cityID}</td>
                            <td>${booking.userID}</td>
                            <td>${booking.num}</td>
                            <td>${booking.roomID}</td>
                            <td> 
                               
                            
                                 <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/DeleteBookingsAdmin" method="post">
                           
                                <input type="hidden" name="Bookinguserid" value="${booking.bookingID}">
                                 <input type="hidden" name="Bookingusername" value="${booking.userID}">
                                
                               <br><br>
                                <button type="submit" class="btn btn-success">Delete Booking</button>
                                 </form>
                            </td>
                            
                            
                        </tr>
                    </c:forEach>

                    </tbody>
                    </table>

                <c:if test="${empty requestScope.allbookings}">
                    <div class="alert alert-info">
                        <div align="center">No Room Assigned to the User.</div>
                    </div>
                </c:if>
                        
                

               

</div>

<%--end content--%>

<%@ include file="../common/newfooter.jsp"%>