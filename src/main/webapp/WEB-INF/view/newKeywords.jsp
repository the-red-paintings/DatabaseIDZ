<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 02.02.2017
  Time: 23:38
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
<form:form action="/keywords/addKeywords" commandName="keywords" method="post">
    <form:input path="language" placeholder="lang"></form:input>
    <form:input path="word" placeholder="word"></form:input>
    <form:select path="articleId">
        <c:forEach var="art" items="${articles}">
            <form:option value="${art.id}">${art.name}</form:option>
        </c:forEach>
    </form:select>
    <button type="submit">Add</button>
</form:form>
</body>
</html>
