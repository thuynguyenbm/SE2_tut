<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 15/02/2022
  Time: 08:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookList</title>
    <!-- File Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<div class="row">
    <div class="col-md-6 text-left"><a href="/book">Book List</a></div>
    <div class="col-md-6 text-right"><a href="/new">Add</a></div>
</div>
<div class="container col-md-6 mt-3">
    <h3 class="text-success text-center">Book List</h3>
    <table class="table table-bordered text-center mt-3">
        <tr>
            <th>Book ID</th>
            <th>Book Title</th>
            <th>Book Author</th>
            <th>Book Price</th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td><c:out value="${book.id}"/></td>
                <td><c:out value="${book.title}"/></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="$${book.price}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</div>
</body>
</html>
