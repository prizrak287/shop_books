<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Authors</title>
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


<div id="main">
    <div id="left">
        <li><a href="http://localhost:8081/">Main</a></li>
        <li><a href="http://localhost:8081/authors">Authors</a></li>
        <li><a href="http://localhost:8081/books">Books</a></li>
    </div>
    <div id="content">
        <table>
            <tr>
                <th>Name</th>
                <th>Books</th>
            </tr>
            <jsp:useBean id="listAuthors" scope="request" type="java.util.List"/>
            <c:forEach var="author" items="${listAuthors}">
                <tr onclick="window.location.href='http://localhost:8081/authors/${author.id}'; return false;">
                    <td>${author.name}</td>
                    <td>
                        <c:forEach var="author" items="${author.books}">
                            <li>${author.name}</li>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>