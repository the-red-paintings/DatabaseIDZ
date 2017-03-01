<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 02.02.2017
  Time: 23:28
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
<form:form action="/autor/add" commandName="autor" method="post">
    <form:input path="fio" placeholder="fio"></form:input>
    <button type="submit">Add</button>
</form:form>
</body>
</html>
