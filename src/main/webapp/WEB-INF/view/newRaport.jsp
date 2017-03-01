<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 02.02.2017
  Time: 23:40
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
<form:form action="/raport/add" commandName="raport" method="post">
    <form:input path="conclusion" placeholder="conclussion"></form:input>
    <form:input path="remark" placeholder="remark"></form:input>
    <form:select path="articleId">
        <c:forEach var="art" items="${articles}">
            <form:option value="${art.id}">${art.name}</form:option>
        </c:forEach>
    </form:select>
    <form:select path="reviewerId">
        <c:forEach var="reviewer" items="${reviewers}">
            <form:option value="${reviewer.id}">${reviewer.fio}</form:option>
        </c:forEach>
    </form:select>
    <button type="submit">Add</button>
</form:form>
</body>
</html>
