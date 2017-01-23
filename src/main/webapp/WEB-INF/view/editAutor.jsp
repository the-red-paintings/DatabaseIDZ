<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 22.01.2017
  Time: 22:55
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
<form:form method="post" commandName="autor" action="/autor/editAutor" >
    <form:input type="hidden" path="id" value="${id}"/>
    <form:input path="fio" value="${fio}"/>
    <button type="submit">Edit</button>
</form:form>
</body>
</html>
