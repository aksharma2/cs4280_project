<%@ include file="../common/newheader.jsp"%>
<%@ include file="../common/header.jspf"%>
<%-- <%@ include file="../common/sidebar.jspf"%> --%>

<%--content--%>

<div class="container">

    <div class="reg">
        <div class="span6 offset3">
            <div class="page-header">
                <h1>Sign in</h1>
            </div>

            <%@ include file="../common/error.jspf"%>

            <form class="well form-horizontal" method="post" action="${pageContext.request.contextPath}/user/login">
                <fieldset >

                    <div class="control-group">
                        <label class="control-label" for="userID" style="color:black">User ID:</label>
                        <div class="controls">
                            <input id="email" name="userID" type="text" class="input-medium" required="required"/>
                            
                        </div>
                    </div>

                    <div class="control-group" style="color:black">
                        <label class="control-label" for="password" style="color:black">Password:</label>
                        <div class="controls">
                            <input type="password" id="password" name="password" class="input-medium" placeholder="min 6 characters" required="required"/>
                            
                        </div>
                    </div>

                     <div class="control-group" style="color:black">
                         
                        <div class="controls">
                            <input type="hidden" id="referer" name="referer"  value="${requestScope.referer}" />
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
