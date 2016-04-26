<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>

<%-- <%@ include file="../common/sidebar.jspf"%> --%>
<%@ include file="../common/newheader.jsp"%>
<%@ include file="../common/header.jspf"%>
<%--content--%>

<div class="container">

    <div class="reg">
        <div class="span6 offset3">
            <div class="page-header">
                <h1>Sign up</h1>
            </div>

             <%@ include file="../common/error.jspf"%>
            
            <form class="well form-horizontal" method="post" action="register">

               

                <fieldset>

                    <div class="control-group">
                        <label class="control-label" for="name" style="color:black">Name:</label>
                        <div class="controls">
                            <input id="name" name="name" type="text" class="input-medium" required="required"/>
                            <p class="help-block alert-error"><c:out value="${requestScope.errorName}"/></p>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="email" style="color:black">User ID:</label>
                        <div class="controls">
                            <input id="email" name="userID" type="text" class="input-medium" required="required"/>
                            <p class="help-block alert-error"><c:out value="${requestScope.errorEmail}"/></p>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="password" style="color:black">Password:</label>
                        <div class="controls">
                            <input type="password" id="password" name="password" class="input-medium" placeholder="min 6 characters" required="required"/>
                            <p class="help-block alert-error"><c:out value="${requestScope.errorPassword}"/></p>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="confirmationPassword" style="color:black">Confirmation password:</label>
                        <div class="controls">
                            <input type="password" id="confirmationPassword" name="confirmationPassword" class="input-medium" placeholder="min 6 characters" required="required"/>
                            <p class="help-block alert-error"><c:out value="${requestScope.errorConfirmationPassword}"/></p>
                            <p class="help-block alert-error"><c:out value="${requestScope.errorConfirmationPasswordMatching}"/></p>
                        </div>
                    </div>

                    <div class="control-group">
                         
                        <div class="controls">
                            <input type="hidden" id="referer" name="referer"  value="${requestScope.referer}" />
                        </div>
                    </div>
                        
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary"><i class="icon-lock icon-white"></i> Sign up</button>
                    </div>

                    <div align="center">
                        You have already an account? <a href="${pageContext.request.contextPath}/user/login">Sign in here</a>
                    </div>

                </fieldset>
            </form>

        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>