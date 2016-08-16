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
    </head>
    <body>
        <table>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td><c:out value="${order.id}"/></td>
                    <td><c:out value="${order.bookId}"/></td>
                    <td><c:out value="${order.userId}"/></td>
                    <td><c:out value="${order.date}"/></td>
                    <td><c:out value="${order.orderType}"/></td>
                    <td><c:out value="${order.statusType}"/></td>
                    <c:if test="${order.statusType == 'PLACED'}">
                        <td>
                            <form name="giveForm" method="POST" action="/MyLibrary/controller">
                                <input type="hidden" name="command" value="givebook" />
                                <input type="hidden" name="orderId" value="${order.id}" />
                                <input type="hidden" name="bookId" value="${order.bookId}" />
                                <input type="submit" value="Give book" />
                            </form>
                        </td>
                    </c:if>
                    <c:if test="${order.statusType == 'GIVEN'}">
                        <td>
                            <form name="returnForm" method="POST" action="/MyLibrary/controller">
                                <input type="hidden" name="command" value="returnbook" />
                                <input type="hidden" name="orderId" value="${order.id}" />
                                <input type="hidden" name="bookId" value="${order.bookId}" />
                                <input type="submit" value="Return book" />
                            </form>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
