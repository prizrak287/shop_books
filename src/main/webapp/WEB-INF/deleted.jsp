<%--
  Created by IntelliJ IDEA.
  User: sbori
  Date: 30.04.2019
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="deleted" scope="request" type="java.lang.String"/>
<jsp:useBean id="entity" scope="request" type="java.lang.String"/>

<html>
<head>
    <title>Deleted ${entity} ${deleted}</title>
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
        <li><a href="http://localhost:8081/authors/all">Authors</a></li>
        <li><a href="http://localhost:8081/books/all">Books</a></li>
    </div>
    <div id="content">
        <h3>${entity} ${deleted} is deleted!</h3>
        <form action="/">
            <button type="submit">На главную</button>
        </form>
    </div>
</div>
</body>
</html>
