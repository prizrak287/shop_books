<jsp:useBean id="authorInfo" scope="request" type="books.entities.Author"/>
<%--
  Created by IntelliJ IDEA.
  User: sbori
  Date: 28.04.2019
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>
    <head>
        <title>${authorInfo.name}</title>
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
            background: #4c80ff;
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
            <li><a href="http://localhost:8081/authors">Authors</a></li>
            <li><a href="http://localhost:8081/books">Books</a></li>
        </div>
        <div id="content">
            <li>Имя: ${authorInfo.name}</li>
            <li>Возраст: ${authorInfo.age}</li>
            <li>Адрес: ${authorInfo.address}</li>
            Список книг:
            <div>
                <c:forEach var="book" items="${authorInfo.books}">
                    <a href="http://localhost:8081/books/${book.id}">
                        <li>${book.name}</li>
                    </a>
                </c:forEach>
            </div>
        </div>
    </div>
    </body>
    </html>
