<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 16/02/2022
  Time: 10:51
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
        <span class="col-md-6 text-left"><a href="/book">Book List</a></span>
        <span class="col-md-6 text-right"><a href="/new">Add</a></span>
    </div>
    <div class="container col-md-6 mt-3">
        <h3 class="text-success text-center">Edit book</h3>
        <form action="/update" method="post" style="border: 2px solid black;padding: 15px">
            <h2>Book Title</h2>
            <input type="text" placeholder="Title">
            <h2>Book Author</h2>
            <input type="text" placeholder="Author">
            <h2>Book Price</h2>
            <input type="text" placeholder="Price">
            <br/>
            <div class="button" style="margin: 15px; text-align: center">
                <button style="background-color: cornflowerblue; padding: 5px 10px">Add</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
