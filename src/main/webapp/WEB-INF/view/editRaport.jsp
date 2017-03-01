<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 08.02.2017
  Time: 22:47
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
<form:form commandName="raport" action="/raport/editRaport" method="post">
    <form:input path="id" type="hidden" value="${id}"></form:input>
    <form:input path="conclusion"  value="${conclusion}"></form:input>
    <form:input path="remark"  value="${remark}"></form:input>
    <select id="articleId">
        <c:forEach var="article" items="${articles}">
            <option value="${article.id}">${article.name}</option>
        </c:forEach>
    </select>
    <select id="reviewerId">
        <c:forEach var="article" items="${reviewers}">
            <option value="${article.id}">${article.fio}</option>
        </c:forEach>
    </select>
    <button type="button" onclick="addAutor()">add article</button>
    <button type="button" onclick="addReviewer()">add reviewer</button>
    <button type="submit">edit</button>
</form:form>
</body>
    <script>
        function addAutor(){
            var articleid = $("#articleId").val();
            console.log(articleid);
            $.ajax({

                url: "/raport/addArticle",
                data: {raportId: ${id}, aricleId: articleid},

            });
        }
        function addReviewer(){
            var articleid = $("#reviewerId").val();
            console.log(articleid);
            $.ajax({

                url: "/raport/addReviewer",
                data: {raportId: ${id}, reviewerId: articleid},

            });
        }
    </script>
</html>
