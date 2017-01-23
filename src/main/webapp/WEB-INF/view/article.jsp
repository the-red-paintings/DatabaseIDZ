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
        <c:forEach var="autor" items="${article.autors}">
            <a href="/autor/${autor.id}">${autor.fio}</a>
        </c:forEach>
    </c:if>
    <p><a href="/article/edit/${article.id}">edit</a></p>
</body>
</html>
