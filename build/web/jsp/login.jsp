<%-- 
    Document   : login
    Created on : 24 лип. 2016, 20:43:20
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <p>Welcome to login page of MyLibrary</p>
        <form name="loginForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="login" />
            Login:<br/>
            <input type="email" name="login" value="" required/>
            <br/>Password:<br/>
            <input type="password" name="password" value="" required/>
            <br/>
            ${errorLoginPassMessage}
            <br/>
            ${wrongAction}
            <br/>
            ${nullPage}
            <br/>
            <input type="submit" value="Log in"/>
        </form>
        <a href="/MyLibrary/jsp/register.jsp">Register</a>
        <hr/>
    </body>
</html>
