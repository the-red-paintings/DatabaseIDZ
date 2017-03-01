<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 22.01.2017
  Time: 21:04
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
    <p>${article.name}</p>
    <p>${article.language}</p>
    <p>${article.text}</p>
    <c:if test="${not empty article.autors}">
        <p>autors</p>
        <c:forEach var="autor" items="${article.autors}">
            <a href="/autor/${autor.id}">${autor.fio}</a>
        </c:forEach>
    </c:if>
    <br>
    <c:if test="${not empty article.annotations}">
        <p>annotations</p>
        <c:forEach var="annotation" items="${article.annotations}">
            <a href="/annotation/${annotation.id}">${annotation.text}</a>
        </c:forEach>
    </c:if>
    <br>
    <c:if test="${not empty article.grades}">
        <p>grades</p>
        <c:forEach var="grade" items="${article.grades}">
            <a href="/grade/${grade.id}">${grade.mark}</a>
        </c:forEach>
    </c:if>
    <br>
    <c:if test="${not empty article.keywords}">
        <p>keywords</p>
        <c:forEach var="keyword" items="${article.keywords}">
            <a href="/keywords/${keyword.id}">${keyword.word}</a>
        </c:forEach>
    </c:if>
    <br>
    <c:if test="${not empty article.raports}">
        <p>raports</p>
        <c:forEach var="raport" items="${article.raports}">
            <a href="/raport/${raport.id}">${raport.conclusion}</a>
        </c:forEach>
    </c:if>
    <br>
    <c:if test="${not empty article.reviewers}">
        <p>reviewers</p>
        <c:forEach var="reviewer" items="${article.reviewers}">
            <a href="/reviewer/${reviewer.id}">${reviewer.fio}</a>
        </c:forEach>
    </c:if>
    <p><a href="/article/edit/${article.id}">edit</a></p>
    <a href="/new">new</a>
</body>
</html>
