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
                    <h1>User's Registered to this system</h1>
                </div>

                <%@ include file="../common/error.jspf"%>
                
                
            
                
                <table class="table table-bordered table-striped">

                    <thead>
                    <tr>
                    <th>Hotel View </th>
                    <th>Hotel</th>
                    <th>City</th>
                   <th>Book Now!</th>
                        
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${requestScope.imgs}" var="hot">
                        <tr>
                            
                        <td><img src="${hot.HURL}" height="200" width="150" ></td>
                        <td><h3>${hot.HName}</h3></td>
                        <td><h3>${hot.HCity}</h3></td>
                           <td>
                                <form action="${pageContext.request.contextPath}/BookMyRoom" method="get">
                                    <INPUT TYPE=hidden NAME="hotelU" VALUE="${hot.HURL}">
                                    <INPUT TYPE=hidden NAME="hotelN" VALUE="${hot.HName}">
                                    <INPUT TYPE=hidden NAME="hotelC" VALUE="${hot.HCity}">
                                    
                                   <button type="submit" class="btn btn-warning">BOOK NOW!</button>
                                </form>
                              
                            </td>
                            
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
