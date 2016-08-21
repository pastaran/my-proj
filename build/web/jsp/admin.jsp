<%-- 
    Document   : admin
    Created on : 30 лип. 2016, 17:29:21
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin</title>
    </head>
    <body>
        <h3>Hello, ${userName}! Make your choice.</h3>
        <form name="showAuthorsForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="showauthors" />
            <input type="submit" value="Show authors"/>
        </form>
        <form name="showBooksForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="showbooks" />
            <input type="submit" value="Show books"/>
        </form>
        <form name="showOrdersForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="showorders" />
            <input type="submit" value="Show orders"/>
        </form>
        <form name="showReadersForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="showreaders" />
            <input type="submit" value="Show readers"/>
        </form>
        <a href="/MyLibrary/jsp/login.jsp">Home</a>
        <form name="logoutForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="logout" />
            <input type="submit" value="Sign out"/>
        </form>
    </body>
</html>
