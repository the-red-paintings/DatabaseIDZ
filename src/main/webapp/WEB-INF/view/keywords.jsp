<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 29.01.2017
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>${keyword.language}</p>
    <p>${keyword.word}</p>
    <c:if test="${not empty keyword.article}">
        <a href="/article/${keyword.article.id}">${keyword.article.name}</a>
    </c:if>
    <a href="/keywords/edit/${keyword.id}">Edit</a>
    <a href="/keywords/new">new</a>
</body>
</html>
