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
                    <h1>Users Registered to this system</h1>
                </div>

                <table class="table table-bordered table-striped">

                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>ID</th>
                        <th>Action</th>
                        <th>Confirm</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${requestScope.userList}" var="currentUser">
                        <tr>
                            <td>${currentUser.name}</td>
                            <td>Resolve Later!</td>
                            <%--
                            <td><span class="label <tl:statusStyle status="${currentTodo.done}"/> "> <tl:statusLabel status="${currentTodo.done}"/></span></td>
                            <td>
                                <a class="btn btn-mini btn-danger" data-toggle="modal" href="#confirm_delete_${currentTodo.id}"><i class="icon-remove icon-white"></i> Delete</a>
                                <div class="modal hide" id="confirm_delete_${currentTodo.id}">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">×</button>
                                        <h3>Confirmation</h3>
                                    </div>
                                    <div class="modal-body">
                                        <p>Are you sure to delete todo ${currentTodo.id} '${currentTodo.title}' ?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <form action="/todos/delete.do" method="post">
                                            <input type="hidden" name="todoId" value="${currentTodo.id}">
                                            <a href="#" class="btn" data-dismiss="modal">Cancel</a> <button type="submit" class="btn btn-primary">Confirm</button>
                                        </form>
                                    </div>
                                </div>
                            </td>--%>
                        </tr>
                    </c:forEach>

                    </tbody>
                    <tfoot>
                    <tr>
                        
                        <td colspan="2"><div align="center">Todo = <span class="badge">${requestScope.userCount}</span></div></td>
                        
                    </tr>
                    </tfoot>
                </table>

                <c:if test="${empty requestScope.userList}">
                    <div class="alert alert-info">
                        <div align="center">Your todo list is empty !</div>
                    </div>
                </c:if>

                <c:if test="${not empty requestScope.userList}">
                <div align="center">
                    <button class="btn" onclick="javascript:window.print()">
                        <i class="icon-print"></i>
                        Print my todo list
                    </button>
                </div>
                </c:if>

            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>
