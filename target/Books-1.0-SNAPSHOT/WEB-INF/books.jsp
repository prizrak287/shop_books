<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Books</title>
    <style type="text/css">
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #108c07;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #23ddbb;
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


<div id="main">
    <div id="left">
        <li><a href="http://localhost:8081/">Main</a></li>
        <li><a href="http://localhost:8081/authors/all">Authors</a></li>
        <li><a href="http://localhost:8081/books/all">Books</a></li>
    </div>
    <div id="content">
        <form action="/bookSearch">
            <input type="text" name="book_name"/>
            <input type="submit" value="Search"/>
        </form>
        <table>
            <tr>
                <th>Name</th>
                <th>Author</th>
                <th>Action</th>
            </tr>
            <jsp:useBean id="listBooks" scope="request" type="java.util.List"/>
            <c:forEach var="book" items="${listBooks}">
                <tr onclick="window.location.href='http://localhost:8081/books/${book.id}'">
                    <td>${book.name}</td>
                    <td>${book.author.name}</td>
                    <td>
                        <form action="<c:url value="/deleteBook"/>" method="post">
                            <input type="hidden" name="id" value="${book.id}">
                            <input type="submit" value="Delete" style="float:left">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>