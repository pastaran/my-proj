<%-- 
    Document   : error
    Created on : 24 лип. 2016, 22:09:54
    Author     : Kostya
--%>

<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Error Page</title>
    </head>
    <body>
        Request from ${pageContext.errorData.requestURI} is failed
        <br/>
        Servlet name or type: ${pageContext.errorData.servletName}
        <br/>
        Status code: ${pageContext.errorData.statusCode}
        <br/>
        Exception: ${pageContext.errorData.throwable}
        <br/>
        <a href="/MyLibrary/jsp/login.jsp">Home</a>
    </body>
</html>
