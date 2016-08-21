<%-- 
    Document   : main
    Created on : 24 лип. 2016, 22:07:09
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome</title>
    </head>
    <body>
        <h3>Hello, ${userName}! Make your choice.</h3>
        <form name="showBooksForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="showbooks" />
            <input type="submit" value="Show books"/>
        </form>
        <hr/>
        <form name="searchBooksForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="searchbooks" />
            Search:
            <br/>
            <input type="text" name="title" value="" required/>
            <input type="submit" value="Search"/>
            <br/>
            ${errorLoginPassMessage}
            <br/>
        </form>
        <form name="logoutForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="logout" />
            <input type="submit" value="Sign out"/>
        </form>

    </body>
</html>
