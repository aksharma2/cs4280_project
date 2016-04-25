<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>s

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jspf"%>
<%-- <%@ include file="../common/sidebar.jspf"%> --%>
<%@ include file="../common/newheader.jsp"%>
<div class="container">
    
                <table class="table table-bordered table-striped">

                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Rooms</th>
                        <th>Action</th>
                        
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${requestScope.allRecs}" var="recommendation">
                        <tr>
                            <td>${recommendation.hotelID}</td>
                            <td>${recommendation.roomID}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RecommendHotels" method="post">
                                                <input value=${recommendation.index} name="SingleRecomendationIndex" type ="range" min ="0" max="3" step ="1">
                                                <input value=${recommendation.hotelID} name="hotelID" type="hidden" />
                                                <input value=${recommendation.roomID} name="roomID" type="hidden" />
                                                <input type="submit" name="Submit" value="Recommend">
                                </form>
                                        
                            </td>
                            
                        </tr>
                    </c:forEach>

                    </tbody>
                    <tfoot>
                    <tr>
                        
                        
                        
                    </tr>
                    </tfoot>
                </table>

               

                <c:if test="${not empty requestScope.userList}">
                <div align="center">
                   
                    <form action="Delete" method="post">
                        <button type="submit" class="btn btn-primary">Clear Table</button>
                    </form>
                    
                    
                </div>
                </c:if>
<%--
            </div>
        </div>
    </div> --%>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>
