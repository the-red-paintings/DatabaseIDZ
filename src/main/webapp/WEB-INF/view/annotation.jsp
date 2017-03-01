<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 29.01.2017
  Time: 21:19
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
    <p>${annotation.language}</p>
    <p>${annotation.text}</p>
    <c:if test="${not empty annotation.article}">
        <a href="/article/${annotation.article.id}" >${annotation.article.name}</a>
    </c:if>
    <a href="/annotation/edit/${annotation.id}">edit</a>
    <a href="/annotation/new">new</a>
</body>
</html>
