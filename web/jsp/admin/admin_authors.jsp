<%-- 
    Document   : admin_authors
    Created on : 31 лип. 2016, 17:40:00
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin authors</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <script src="js/myScript.js"></script>
    </head>
    <body>
        <h1>Admin authors</h1>
        <a href="/MyLibrary/jsp/admin/add_author.jsp">Create</a>
        <br />
        <button onclick="goBack()" class="margin_updown">Go Back</button>
        <table>
            <tr>
                <th>Name</th>
            </tr>
            <c:forEach var="author" items="${authors}">
                <tr>
                    <td><c:out value="${author.name}"/></td>
                    <td>
                        <form name="goUpdateForm" method="POST" action="/MyLibrary/controller">
                            <input type="hidden" name="command" value="goupdateauthor" />
                            <input type="hidden" name="authorId" value="${author.id}" />
                            <input type="submit" value="Update" />
                        </form>
                    </td>
                    <td>
                        <form name="deleteForm" method="POST" action="/MyLibrary/controller">
                            <input type="hidden" name="command" value="deleteauthor" />
                            <input type="hidden" name="authorId" value="${author.id}" />
                            <input type="submit" value="Delete" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
