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
                    <h1>User's Registered to this system</h1>
                </div>

                <table class="table table-bordered table-striped">

                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Action</th>
                        
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${requestScope.userList}" var="currentUser">
                        <tr>
                            <td>${currentUser.id}</td>
                            <td>${currentUser.name}</td>
                            <td>
                                
                                <form action="${pageContext.request.contextPath}/user/delete" method="post">
                                    <input type="hidden" name="idToDel" value=${currentUser.id}>
                                    <button type="submit" class="btn btn-primary">DELETE</button>
                                </form>
                                
                            </td>
                            
                        </tr>
                    </c:forEach>

                    </tbody>
                    <tfoot>
                    <tr>
                        
                        <td colspan="2"><div align="center">User Count = <span class="badge">${requestScope.userCount}</span></div></td>
                        
                    </tr>
                    </tfoot>
                </table>

                <c:if test="${empty requestScope.userList}">
                    <div class="alert alert-info">
                        <div align="center">No one is registered to the system... Even you're fucking removed, mate!</div>
                    </div>
                </c:if>

                <c:if test="${not empty requestScope.userList}">
                <div align="center">
                   
                    <form action="Delete" method="post">
                        <button type="submit" class="btn btn-primary">Clear Table</button>
                    </form>
                    
                </div>
                </c:if>

            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>
