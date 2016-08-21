<%-- 
    Document   : admin_books
    Created on : 31 лип. 2016, 15:32:02
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin books</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <script src="js/myScript.js"></script>
    </head>
    <body>
        <h1>Admin books</h1>
        <form name="goAddForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="goaddbook" />
            <input type="submit" value="Create" />
        </form>
        <br />
        <button onclick="goBack()" class="margin_updown">Go Back</button>
        <table>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Year</th>
                <th>Total</th>
                <th>Available</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td><c:out value="${book.title}"/></td>
                    <td><c:out value="${book.author.name}"/></td>
                    <td><c:out value="${book.year}"/></td>
                    <td><c:out value="${book.qtyTotal}"/></td>
                    <td><c:out value="${book.qtyAvailable}"/></td>
                    <td>
                        <form name="goUpdateForm" method="POST" action="/MyLibrary/controller">
                            <input type="hidden" name="command" value="goupdatebook" />
                            <input type="hidden" name="bookId" value="<c:out value='${book.id}'/>" />
                            <input type="submit" value="Update" />
                        </form>
                    </td>
                    <td>
                        <form name="deleteForm" method="POST" action="/MyLibrary/controller">
                            <input type="hidden" name="command" value="deletebook" />
                            <input type="hidden" name="bookId" value="<c:out value='${book.id}'/>" />
                            <input type="submit" value="Delete" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
