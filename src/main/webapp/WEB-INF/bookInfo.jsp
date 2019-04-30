<%--
  Created by IntelliJ IDEA.
  User: sbori
  Date: 28.04.2019
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="bookInfo" scope="request" type="books.entities.Book"/>
<html>
<head>
    <title>${bookInfo.name}</title>
</head>
<style type="text/css">
    #left {
        background: #8dd4ef;
        float: right;
        width: 150px;
        position: relative;
        height: 100%;
    }

    #content {
        background: #ff20d0;
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
<body>
<div id="main">
    <div id="left">
        <li><a href="http://localhost:8081/">Main</a></li>
        <li><a href="http://localhost:8081/authors/all">Authors</a></li>
        <li><a href="http://localhost:8081/books/all">Books</a></li>
    </div>
    <div id="content">
        <li>Название: ${bookInfo.name}</li>
        <a href="http://localhost:8081/authors/${bookInfo.author.id}">
            <li>Автор: ${bookInfo.author.name}</li>
        </a>
        <li>Издательство: ${bookInfo.publishingHouse}</li>
        <li>Дата издательства: ${bookInfo.datePublishing}</li>
    </div>
</div>
</body>
</html>
