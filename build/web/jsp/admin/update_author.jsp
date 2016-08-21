<%-- 
    Document   : update_author
    Created on : Aug 9, 2016, 1:12:56 PM
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Update author</title>
        <script src="js/myScript.js"></script>
    </head>
    <body>
        <form name="updateAuthorForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="updateauthor" />
            Author name:<br/>
            <input type="text" name="authorName" value="<c:out value='${author.name}'/>" maxlength="64" required/>
            <input type="hidden" name="authorId" value="<c:out value='${author.id}'/>" />
            <br/>
            <input type="submit" value="Update"/>
        </form>
        <button onclick="goBack()" class="margin_updown">Go Back</button>
    </body>
</html>
