<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Authors</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <style type="text/css">
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dd8762;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #ddd03a;
        }

        #left {
            background: #8dd4ef;
            float: right;
            width: 150px;
            position: relative;
            height: 100%;
        }

        #content {
            background: #d9ffd2;
            float: left;
            width: 100%;
            position: relative;
            height: 100%;
        }

        #main {
            background: gray;
            width: 100%;
            height: 800px;
            margin-top: 0;
            display: flex;
        }
    </style>
</head>

<body>

<jsp:useBean id="listAuthors" scope="request" type="java.util.List<books.entities.Author>"/>
<div id="main">
    <div id="left">
        <li><a href="http://localhost:8081/">Main</a></li>
        <li><a href="http://localhost:8081/authors/all">Authors</a></li>
        <li><a href="http://localhost:8081/books/all">Books</a></li>
    </div>
    <div id="content">
        <form action="<c:url value="/authors/search"/>" method="get">
            <input type="text" name="author_name"/>
            <input type="submit" value="Search"/>
        </form>
        <table>
            <tr>
                <th>Name</th>
                <th>Books</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="author" items="${listAuthors}">
                <tr>
                    <td>${author.name}</td>
                    <td>
                        <c:forEach var="book" items="${author.books}">
                            <li>${book.name}</li>
                        </c:forEach>
                    </td>
                    <td>
                        <form action="<c:url value="/authors/info"/>" method="get">
                            <input type="hidden" name="id" value="${author.id}">
                            <input type="submit" value="Info" style="float:left">
                        </form>
                        <form action="<c:url value="/authors/delete"/>" method="post">
                            <input type="hidden" name="id" value="${author.id}">
                            <input type="submit" value="Delete" style="float:left">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <form action="<c:url value="/authors/add"/>" method="post" id="authorForm">
            <strong>Author</strong><br>
            Author name
            <label for="author_name"></label>
            <input type="text" name="author_name" id="author_name"/>

            Age
            <label for="age"></label>
            <input type="text" name="age" id="age"/>

            Address
            <label for="address"></label>
            <input type="text" name="address" id="address"/><br>
            <strong>Book</strong><br>

            Book name
            <label for="book_name"></label>
            <input type="text" name="book_name" id="book_name"/>

            Publishing House
            <label for="publishingHouse"></label>
            <input type="text" name="publishingHouse" id="publishingHouse"/>

            Date publishing
            <label for="datePublishing"></label>
            <input type="text" name="datePublishing" id="datePublishing"/><br>
        </form>
        <input type="submit" value="Add author" onclick="send()"/>
        <script type="text/javascript">
            function send() {
                var json = {
                    author_name: document.getElementById('author_name').value,
                    age: document.getElementById('age').value,
                    address: document.getElementById('address').value,
                    books: [{
                        book_name: document.getElementById('book_name').value,
                        publishingHouse: document.getElementById('publishingHouse').value,
                        datePublishing: document.getElementById('datePublishing').value
                    }]
                };
                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: '/authors/add',
                    type: 'POST',
                    data: JSON.stringify(json),
                    dataType: 'json',
                    success: function (result) {
                        alert(result.responseText + ' will refresh page')
                    },
                    error: function (err) {
                        alert(err.responseText)
                    }
                });
            }
        </script>
    </div>
</div>

</body>
</html>