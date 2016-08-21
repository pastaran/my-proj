<%-- 
    Document   : admin_orders
    Created on : Aug 8, 2016, 12:38:21 PM
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin orders</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <script src="js/myScript.js"></script>
    </head>
    <body>
        <br/>
        ${errorGiveBook}
        <br/>
        <table>
            <tr>
                <th>Id</th>
                <th>Book title</th>
                <th>User name</th>
                <th>Date</th>
                <th>OrderType</th>
                <th>StatusType</th>
            </tr>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td><c:out value="${order.id}"/></td>
                    <td><c:out value="${order.book.title}"/></td>
                    <td><c:out value="${order.user.name}"/></td>
                    <td><c:out value="${order.date}"/></td>
                    <td><c:out value="${order.orderType}"/></td>
                    <td><c:out value="${order.statusType}"/></td>
                    <c:if test="${order.statusType == 'PLACED'}">
                        <td>
                            <form name="giveForm" method="POST" action="/MyLibrary/controller">
                                <input type="hidden" name="command" value="givebook" />
                                <input type="hidden" name="orderId" value="<c:out value='${order.id}'/>" />
                                <input type="hidden" name="bookId" value="<c:out value='${order.book.id}'/>" />
                                <input type="submit" value="Give book" />
                            </form>
                        </td>
                    </c:if>
                    <c:if test="${order.statusType == 'GIVEN'}">
                        <td>
                            <form name="returnForm" method="POST" action="/MyLibrary/controller">
                                <input type="hidden" name="command" value="returnbook" />
                                <input type="hidden" name="orderId" value="<c:out value='${order.id}'/>" />
                                <input type="hidden" name="bookId" value="<c:out value='${order.book.id}'/>" />
                                <input type="submit" value="Return book" />
                            </form>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
