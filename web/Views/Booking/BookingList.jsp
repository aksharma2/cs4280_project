<%-- 
    Document   : BookingList
    Created on : Apr 2, 2016, 11:48:51 PM
    Author     : shrankhla
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jspf"%>

<div class="container">
    <div class="row">
        <div class="span3">
            <%@ include file="../common/sidebar.jspf"%>
        </div>
        <div class="span9">
            <div class="well">
                <div class="page-header">
                    <h1>User's Bookings on this System</h1>
                </div>

                
                
                <table class="table table-bordered table-striped">

                    <thead>
                    <tr>
                        <th>Hotel</th>
                        <th>Room Type</th>
                        <th>UserName</th>
                        
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${requestScope.allbookings}" var="Booking">
                        <tr>
                            <td>${Booking.getHotelID()}</td>
                            <td>${Booking.getRoomID()}</td>
                            <td>${Booking.getUserID()}</td>
                            
                        </tr>
                    </c:forEach>

                    </tbody>
                   
                   
                </table>

               

            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>

