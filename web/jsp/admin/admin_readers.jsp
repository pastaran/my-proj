<%-- 
    Document   : admin_readers
    Created on : Aug 18, 2016, 1:38:15 PM
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin readers</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <script src="js/myScript.js"></script>
    </head>
    <body>
        <h1>Admin readers</h1>
        <br />
        <button onclick="goBack()" class="margin_updown">Go Back</button>
        <table>
            <tr>
                <th>Name</th>
                <th>Email</th>
            </tr>
            <c:forEach var="user" items="${readers}">
                <tr>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td>
                        <form name="showReaderOrdersForm" method="POST" action="/MyLibrary/controller">
                            <input type="hidden" name="command" value="showreaderorders" />
                            <input type="hidden" name="userId" value="<c:out value='${user.id}'/>" />
                            <input type="submit" value="Show orders" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
