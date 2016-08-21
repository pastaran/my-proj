<%-- 
    Document   : reg_success
    Created on : 31 лип. 2016, 22:50:15
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resource.text" />
<html>
    <head>
        <title><fmt:message key="reg.success.title"/></title>
    </head>
    <body>
        <h3>${userName}<fmt:message key="reg.success.welcome"/></h3>
        <p><fmt:message key="reg.success.goto"/></p>
        <a href="/MyLibrary/jsp/login.jsp"><fmt:message key="reg.success.button.login"/></a>
    </body>
</html>
