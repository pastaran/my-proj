<%-- 
    Document   : register
    Created on : Jul 27, 2016, 11:34:44 AM
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resource.text" />
<!DOCTYPE html>
<html>
    <head>
        <title><fmt:message key="register.title"/></title>
    </head>
    <body>
        <form name="registerForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="register" />
            <fmt:message key="register.name"/>:<br/>
            <input type="text" name="name" value="" maxlength="16" required/>
            <br/><fmt:message key="register.email"/>:<br/>
            <input type="email" name="email" value="" required/>
            <br/><fmt:message key="register.password"/>:<br/>
            <input type="password" name="password" value="" maxlength="32" required/>
            <br/>
            ${errorRegisterMessage}
            <br/>
            <input type="submit" value="<fmt:message key='register.register'/>"/>
        </form>
    </body>
</html>
