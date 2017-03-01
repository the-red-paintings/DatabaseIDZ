<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 29.01.2017
  Time: 21:42
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
    <p>${grade.mark}</p>
    <c:if test="${not empty grade.article}">
        <a href="/article/${grade.article.id}">${grade.article.name}</a>
    </c:if>
    <c:if test="${ not empty grade.reviewer}">
        <a href="/reviewer/${grade.reviewer.id}">${grade.reviewer.fio}</a>
    </c:if>
`   <a href="/grade/edit/${grade.id}">edit</a>
    <a href="/grade/new">new</a>
</body>
</html>
