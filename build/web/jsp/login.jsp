<%-- 
    Document   : login
    Created on : 24 лип. 2016, 20:43:20
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
        <title><fmt:message key="login.title"/></title>
    </head>
    <body>
        <form method="POST">
            <select id="language" name="language" onchange="submit()">
                <option value="en" ${language == 'en' ? 'selected' : ''}>english</option>
                <option value="uk" ${language == 'uk' ? 'selected' : ''}>українська</option>
            </select>
        </form>
        <p><fmt:message key="login.welcome"/></p>
        <form name="loginForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="login" />
            <fmt:message key="login.login"/>:<br/>
            <input type="email" name="login" value="" required/>
            <br/><fmt:message key="login.password"/>:<br/>
            <input type="password" name="password" value="" required/>
            <br/>
            ${errorLoginPassMessage}
            <br/>
            ${wrongAction}
            <br/>
            ${nullPage}
            <br/>
            <input type="submit" value="<fmt:message key='login.button.submit'/>"/>
        </form>
        <a href="/MyLibrary/jsp/register.jsp"><fmt:message key="login.register"/></a>
        <hr/>
    </body>
</html>
