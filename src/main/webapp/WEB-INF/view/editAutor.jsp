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
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"
            type="text/javascript"></script>
</head>
<body>
<form:form method="post" commandName="autor" action="/autor/editAutor" >
    <form:input type="hidden" path="id" value="${id}"/>
    <form:input path="fio" value="${fio}"/>
    <select id="articleId">
        <c:forEach var="art" items="${articles}">
            <option value="${art.id}">${art.name}</option>
        </c:forEach>
    </select>
    <button type="button" onclick="addArticle()">add article</button>
    <button type="submit">Edit</button>
</form:form>
<script>
    function addArticle(){
        var articleid = $("#articleId").val();
        console.log(articleid);
        $.ajax({
            type: "post",
            url: "/autor/addArticle",
            data: {articleId: articleid, autorId:${autor.id}},
            success:function(data){
                console.log(data);
                document.location.href = "/autor/"+${autor.id};
            }
        });
    }
</script>
</body>
</html>
