<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 11.02.2017
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<html>
<head>
    <title>Title</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"
            type="text/javascript"></script>
</head>
<body>
    <form:form action="/reviewer/editReviewer" commandName="reviewer" method="post">
        <form:input path="id" type="hidden" value="${id}"></form:input>
        <form:input path="fio"  value="${fio}"></form:input>
        <select id="gradeId">
            <c:forEach var="article" items="${grades}">
                <option value="${article.id}">${article.mark}</option>
            </c:forEach>
        </select>
        <select id="raportId">
            <c:forEach var="article" items="${raports}">
                <option value="${article.id}">${article.conclusion}</option>
            </c:forEach>
        </select>
        <button type="button" onclick="addGrade()">add Grade</button>
        <button type="button" onclick="addRaport()">add Raport</button>
        <button type="submit">edit</button>
    </form:form>
</body>
<script>
    function addGrade(){
        var articleid = $("#gradeId").val();
        console.log(articleid);
        $.ajax({

            url: "/reviewer/addGrade",
            data: {reviewerId: ${id}, gradeId: articleid},

        });
    }
    function addRaport(){
        var articleid = $("#raportId").val();
        console.log(articleid);
        $.ajax({

            url: "/reviewer/addRaport",
            data: {reviewerId: ${id}, raportId: articleid},

        });
    }
</script>
</html>
