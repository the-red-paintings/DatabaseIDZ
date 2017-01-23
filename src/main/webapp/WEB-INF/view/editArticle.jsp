<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 22.01.2017
  Time: 21:29
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
    <form:form method="post" commandName="article" action="/editarticle" >
        <form:input type="hidden" path="id" value="${id}"/>
        <form:input path="name" value="${name}"/>
        <form:input path="language" value="${language}"/>
        <form:input path="text" value="${text}"/>
        <button type="submit">Edit</button>
    </form:form>
</body>
</html>
