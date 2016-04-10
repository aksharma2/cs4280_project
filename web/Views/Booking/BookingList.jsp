<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>s

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jspf"%>
<%@ include file="../common/sidebar.jspf"%>

<div class="container">
    <div class="row">
        <div class="span3">
            
        </div>
        
        
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
                        <th>Hotel ID</th>
                        <th>City</th>
                        <th>User</th>
                        <th>Room Assigned</th>
                        
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${requestScope.allbookings}" var="booking">
                        <tr>
                            <td>${booking.hotelID}</td>
                            <td>${booking.getCityID()}</td>
                            <td>${booking.userID}</td>
                            <td>${booking.roomID}</td>
                            
                            
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
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>
