<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 09.02.2017
  Time: 21:58
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
    <form:form commandName="keywords" action="/keywords/editKeyword" method="post">
        <form:input path="id" type="hidden" value="${id}"></form:input>
        <form:input path="language" value="${language}"></form:input>
        <form:input path="word" value="${word}"></form:input>
        <select id="articleId">
            <c:forEach var="article" items="${articles}">
                <option value="${article.id}">${article.name}</option>
            </c:forEach>
        </select>
        <button type="button" onclick="addArticle()">add article</button>
        <button type="submit">edit</button>
    </form:form>
</body>
<script>
    function addArticle(){
        var articleid = $("#articleId").val();
        console.log(articleid);
        $.ajax({
            url: "/keywords/addArticle",
            data: {keywordId: ${id}, articleId: articleid},
            success(data){
                console.log(data);
            }
        });
    }
</script>
</html>
