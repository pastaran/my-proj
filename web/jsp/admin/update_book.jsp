<%-- 
    Document   : update_book
    Created on : Aug 17, 2016, 2:36:41 PM
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Update book</title>
        <script src="../../js/myScript.js"></script>
    </head>
    <body>
        <form name="updateBookForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="updatebook" />
            Book title:<br/>
            <input type="text" name="bookTitle" value="<c:out value='${book.title}'/>" maxlength="255" required/>
            <input type="hidden" name="bookId" value="<c:out value='${book.id}'/>" />
            <br/>
            Author:<br/>
            <select name="authorId" required>
                <option value="<c:out value='${book.author.id}'/>" selected><c:out value="${book.author.name}"/></option>
                <c:forEach var="author" items="${authors}">
                    <option value="<c:out value='${author.id}'/>"><c:out value="${author.name}"/></option>
                </c:forEach>
            </select>
            <br/>
            Year:<br/>
            <input type="number" name="bookYear" value="<c:out value='${book.year}'/>" min="1901" max="2155" required/>
            <br/>
            Quantity total:<br/>
            <input type="number" name="bookQtyTotal" value="<c:out value='${book.qtyTotal}'/>" min="1" required/>
            <br/>
            Quantity available:<br/>
            <input type="number" name="bookQtyAvailable" value="<c:out value='${book.qtyAvailable}'/>" min="0" required/>
            <br/>
            <input type="submit" value="Update"/>
        </form>
        <button onclick="goBack()" class="margin_updown">Go Back</button>
    </body>
</html>
