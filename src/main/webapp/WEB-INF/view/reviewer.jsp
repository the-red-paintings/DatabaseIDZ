<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 29.01.2017
  Time: 22:02
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
    <p>${reviewer.fio}</p>
    <c:if test="${not empty reviewer.articles}">
        <c:forEach var="article" items="${reviewer.articles}">
            <a href="/article/${article.id}">${article.name}</a>
        </c:forEach>
    </c:if>
    <c:if test="${not empty reviewer.gradeList }">
        <c:forEach var="grade" items="${reviewer.gradeList}">
            <a href="/grade/${grade.id}">${grade.mark}</a>
        </c:forEach>
    </c:if>
    <c:if test="${not empty reviewer.raportList}">
        <c:forEach var="raport" items="${reviewer.raportList}">
            <a href="/raport/${raport.id}">${raport.conclusion}</a>
        </c:forEach>
    </c:if>
    <a href="/reviewer/edit/${id}">edit</a>
    <a href="/reviewer/new">new</a>
</body>
</html>
