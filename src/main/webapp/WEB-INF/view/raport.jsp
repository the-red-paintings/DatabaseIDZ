<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 29.01.2017
  Time: 21:53
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
    <p>${raport.conclusion}</p>
    <p>${raport.remark}</p>
    <c:if test="${not empty raport.article}">
        <a href="/article/${raport.article.id}">${raport.article.name}</a>
    </c:if>
    <c:if test="${not empty raport.reviewer}">
        <a href="/reviewer/${raport.reviewer.id}">${raport.reviewer.fio}</a>
    </c:if>
    <a href="/raport/edit/${raport.id}">edit</a>
    <a href="/raport/new">new</a>
</body>
</html>
