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
                    <c:forEach items="${requestScope.allHotels}" var="currentUser">
                        <tr>
                            <td>${currentUser}</td>
                            <td>
                                <table>
                                    <tr>
                                        <td>Single</td>
                                        <td>
                                            <form action="${pageContext.request.contextPath}/RecommendHotels" method="post">
                                                <input id="SingleRecomendationIndex" type ="range" min ="0" max="3" step ="1"/>
                                                <input type="submit" name="Submit">
                                            </form>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Deluxe</td>
                                        <td>
                                            <form action="${pageContext.request.contextPath}/RecommendHotels" method="post">
                                                <input id="DeluxeRecomendationIndex" type ="range" min ="0" max="3" step ="1"/>
                                                <input type="submit" name="Submit">
                                            </form>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Suite</td>
                                        <td>
                                            <form action="${pageContext.request.contextPath}/RecommendHotels" method="post">
                                                <input id="SuiteRecomendationIndex" type ="range" min ="0" max="3" step ="1"/>
                                                <input type="submit" name="Submit">
                                            </form>
                                        </td>
                                    </tr>

                                </table>
                            </td>
                            <%--
                            <td>${currentUser.name}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/admin/editAccess" method="post">
                                    <p>User Access</p>
                                    <input type="hidden" name="idToEdit" value=${currentUser.id}>
                                    <div class="checkbox">
                                        <c:if test="${currentUser.isAdmin}">
                                            <label style="color:black"><input name="role_admin" type="checkbox" value="ROLE_ADMIN" checked >ADMINISTRATOR</label>
                                        </c:if>
                                        <c:if test="${not currentUser.isAdmin}">
                                            <label style="color:black"><input name="role_admin" type="checkbox" value="ROLE_ADMIN" >ADMINISTRATOR</label>
                                        </c:if>
                                    </div>
                        S            <div class="checkbox">
                                        <c:if test="${currentUser.isManager}">
                                            <label style="color:black"><input name="role_hotel_manager" type="checkbox" value="ROLE_HOTEL_MANAGER" checked >HOTEL MANAGER</label>
                                        </c:if>
                                        <c:if test="${not currentUser.isManager}">
                                            <label style="color:black"><input name="role_hotel_manager" type="checkbox" value="ROLE_HOTEL_MANAGER" >HOTEL MANAGER</label>
                                        </c:if>
                                    </div>
                                    <button type="submit" class="btn btn-warning">EDIT User Access</button>
                                </form>
                                <form action="${pageContext.request.contextPath}/user/delete" method="post">
                                    <input type="hidden" name="idToDel" value=${currentUser.id}>
                                    <button type="submit" class="btn btn-danger">DELETE</button>
                                </form>
                            </td>
                            --%>
                        </tr>
                    </c:forEach>

                    </tbody>
                    <tfoot>
                    <tr>
                        
                        
                        
                    </tr>
                    </tfoot>
                </table>

                <c:if test="${empty requestScope.userList}">
                    <div class="alert alert-info">
                        <div align="center">No one is registered to the system.</div>
                    </div>
                </c:if>
                        
                

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
