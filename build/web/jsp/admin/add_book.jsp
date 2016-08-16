<%-- 
    Document   : add_book
    Created on : Aug 16, 2016, 10:05:29 AM
    Author     : Kostya
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create book</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <script src="../../js/myScript.js"></script>
    </head>
    <body>
        <form name="addBookForm" method="POST" action="/MyLibrary/controller">
            <input type="hidden" name="command" value="addbook" />
            Book title:<br/>
            <input type="text" name="bookTitle" value="" maxlength="255" required/>
            <br/>
            Author:<br/>
            <input type="text" name="bookAuthor" value="" required/>
            <br/>
            Year:<br/>
            <input type="number" name="bookYear" value="" min="1901" max="2155" required/>
            <br/>
            Quantity total:<br/>
            <input type="number" name="bookQtyTotal" value="" min="1" required/>
            <br/>
            Quantity available:<br/>
            <input type="text" name="bookQtyAvailable" value="" min="0" required/>
            <br/>
            <input type="submit" value="Submit"/>
        </form>
        <button onclick="goBack()" class="margin_updown">Go Back</button>
    </body>
</html>
