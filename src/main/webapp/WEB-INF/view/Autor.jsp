<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 22.01.2017
  Time: 22:37
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
    <p>${autor.fio}</p>
    <c:if test="${not empty autor.articles}">
        <c:forEach var="article" items="${autor.articles}">
            <a href="/article/${article.id}">${article.name}</a>
            <a href="/autor/edit/${autor.id}">Edit</a>
        </c:forEach>
    </c:if>
</body>
</html>
