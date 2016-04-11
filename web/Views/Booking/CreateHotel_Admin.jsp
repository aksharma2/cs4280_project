<%-- 
    Document   : CreateHotel_Admin
    Created on : 12 Apr, 2016, 12:46:41 AM
    Author     : aksharma2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../common/newheader.jsp"%>
<%@page import="hotelBooking.core.domain.Hotel"%>
<%@page import="hotelBooking.core.jdbc.HotelDBHandler"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/form.css" />
         <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/hoteltable.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="/HotelService" />
    </body>
</html>
