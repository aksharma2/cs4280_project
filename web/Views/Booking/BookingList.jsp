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
            
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/ShowMyBooking" method="get" >
            
            <button type="submit" class="btn btn-warning">View Your Bookings</button>
            </form>
            
        </div>
        
                
               
                
                <table class="table table-bordered table-striped">

                    <thead>
                    <tr>
                        <th><h1><b>Hotel ID</b><h1></th>
                        <th><h1><b>Booking ID</h1></b></th>
                        <th><h1><b>City</h1></b></th>
                        <th><h1><b>User</h1></b></th>
                        <th><h1><b>Num Of Rooms</h1></b></th>
                        <th><h1></b>Room Assigned<h1></b></th>
                        <th></h1></b>Edit Booking </h1></b></th>
                        
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${requestScope.allbookings}" var="booking">
                        <tr>
                            <td>${booking.hotelID}</td>
                            <td>${booking.bookingID}</td>
                            <td>${booking.cityID}</td>
                            <td>${booking.userID}</td>
                            <td>${booking.num}</td>
                            <td>${booking.roomID}</td>
                            <td> 
                               <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/ViewHotel" method="get">
                                   
                                <input type="hidden" name="bookingUserID" value="${booking.bookingID}">
                                <button type="submit" class="btn btn-warning">Modify Booking</button>
                            
                                </form>
                            
                                 <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/DeleteRoom" method="get">
                           
                                <input type="hidden" name="Bookinguserid" value="${booking.bookingID}">
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
