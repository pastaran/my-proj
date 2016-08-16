<%-- 
    Document   : register
    Created on : Jul 27, 2016, 11:34:44 AM
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <form name="registerForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="register" />
            Name:<br/>
            <input type="text" name="name" value="" maxlength="16" required/>
            <br/>Email:<br/>
            <input type="email" name="email" value="" required/>
            <br/>Password:<br/>
            <input type="password" name="password" value="" maxlength="32" required/>
            <br/>
            ${errorRegisterMessage}
            <br/>
            <input type="submit" value="Register"/>
        </form>
    </body>
</html>
