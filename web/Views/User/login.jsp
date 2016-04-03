<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jspf"%>
<%--content--%>

<div class="container">

    <div class="row">
        <div class="span6 offset3">
            <div class="page-header">
                <h1>Sign in</h1>
            </div>

            <%@ include file="../common/error.jspf"%>

            <form class="well form-horizontal" method="post" action="${pageContext.request.contextPath}/user/login">
                <fieldset>

                    <div class="control-group">
                        <label class="control-label" for="userID">User ID:</label>
                        <div class="controls">
                            <input id="email" name="userID" type="text" class="input-medium" required="required"/>
                            
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="password">Password:</label>
                        <div class="controls">
                            <input type="password" id="password" name="password" class="input-medium" placeholder="min 6 characters" required="required"/>
                            
                        </div>
                    </div>

                     <div class="control-group">
                         <label class="control-label" for="userID">[Test] Referer</label>
                        <div class="controls">
                            <input type="text" id="referer" name="referer"  value="${requestScope.referer}" />
                        </div>
                    </div>
                    
                    
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary"><i class="icon-lock icon-white"></i> Sign in</button>
                    </div>

                    <div align="center">
                        You don't have an account yet? <a href="${pageContext.request.contextPath}/user/register">Register here for free!</a>
                    </div>

                </fieldset>
            </form>

        </div>
    </div>
</div>



<%--end content--%>
<%@ include file="../common/footer.jspf"%>
