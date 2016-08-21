<%-- 
    Document   : main_search
    Created on : 31 лип. 2016, 17:57:36
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Main search</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <script src="js/myScript.js"></script>
    </head>
    <body>
        <button onclick="goBack()" class="margin_updown">Go Back</button>
        <br />
        <table>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Year</th>
                <th>Available</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <c:if test="${book.qtyAvailable > 0}">
                    <tr>
                        <td><c:out value="${book.title}"/></td>
                        <td><c:out value="${book.author.name}"/></td>
                        <td><c:out value="${book.year}"/></td>
                        <td><c:out value="${book.qtyAvailable}"/></td>
                        <td>
                            <form name="orderForm" method="POST" action="/MyLibrary/controller">
                                <input type="hidden" name="command" value="orderbook" />
                                <input type="hidden" name="bookId" value="<c:out value='${book.id}'/>" />
                                <select name="orderType" required>
                                    <option value="reading_room">Reading-room</option>
                                    <option value="abonement">Abonement</option>
                                </select>
                                <input type="submit" value="Order book" />
                            </form>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </body>
</html>
