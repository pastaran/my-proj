<%-- 
    Document   : add_author
    Created on : Aug 9, 2016, 12:54:45 PM
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create author</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <script src="../../js/myScript.js"></script>
    </head>
    <body>
        <form name="addAuthorForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="addauthor" />
            Author name:<br/>
            <input type="text" name="authorName" value="" maxlength="64" required/>
            <br/>
            <input type="submit" value="Submit"/>
        </form>
        <button onclick="goBack()" class="margin_updown">Go Back</button>
    </body>
</html>
