<%-- 
    Document   : add_book
    Created on : Aug 16, 2016, 10:05:29 AM
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Create book</title>
        <script src="../../js/myScript.js"></script>
    </head>
    <body>
        <form name="addBookForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="addbook" />
            Book title:<br/>
            <input type="text" name="bookTitle" value="" maxlength="255" required/>
            <br/>
            Author:<br/>
            <select name="authorId" required>
                <c:forEach var="author" items="${authors}">
                    <option value="<c:out value='${author.id}'/>"><c:out value="${author.name}"/></option>
                </c:forEach>
            </select>
            <br/>
            Year:<br/>
            <input type="number" name="bookYear" value="2016" min="1901" max="2155" required/>
            <br/>
            Quantity total:<br/>
            <input type="number" name="bookQtyTotal" value="1" min="1" required/>
            <br/>
            Quantity available:<br/>
            <input type="number" name="bookQtyAvailable" value="0" min="0" required/>
            <br/>
            <input type="submit" value="Submit"/>
        </form>
        <button onclick="goBack()" class="margin_updown">Go Back</button>
    </body>
</html>
