<%-- 
    Document   : main_books
    Created on : 31 лип. 2016, 15:42:09
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Main books</title>
    </head>
    <body>
        <table>
            <c:forEach var="book" items="${books}">
                <c:if test="${book.qtyAvailable > 0}">
                    <tr>
                        <td><c:out value="${book.title}"/></td>
                        <td><c:out value="${book.author.name}"/></td>
                        <td><c:out value="${book.year}"/></td>
                        <td><c:out value="${book.qtyTotal}"/></td>
                        <td><c:out value="${book.qtyAvailable}"/></td>
                        <td>
                            <form name="orderForm" method="POST" action="/MyLibrary/controller">
                                <input type="hidden" name="command" value="orderbook" />
                                <input type="hidden" name="bookId" value="${book.id}" />
                                <input type="radio" name="orderType" value="reading_room" checked />Reading-room
                                <input type="radio" name="orderType" value="abonement" />Abonement
                                <input type="submit" value="Order book" />
                            </form>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </body>
</html>
