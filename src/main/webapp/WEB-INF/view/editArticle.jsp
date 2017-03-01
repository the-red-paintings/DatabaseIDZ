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
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"
            type="text/javascript"></script>
</head>
<body>
    <form:form method="post" commandName="article" action="/editarticle" >
        <form:input type="hidden" path="id" value="${id}"/>
        <form:input path="name" value="${name}"/>
        <form:input path="language" value="${language}"/>
        <form:input path="text" value="${text}"/>
        <select id="autorId">
            <c:forEach var="art" items="${autors}">
                <option value="${art.id}">${art.fio}</option>
            </c:forEach>
        </select>
        <select id="keywordsId">
            <c:forEach var="art" items="${keywords}">
                <option value="${art.id}">${art.word}</option>
            </c:forEach>
        </select>
        <select id="annotationId">
            <c:forEach var="art" items="${annotations}">
                <option value="${art.id}">${art.text}</option>
            </c:forEach>
        </select>
        <select id="gradeId">
            <c:forEach var="art" items="${grades}">
                <option value="${art.id}">${art.mark}</option>
            </c:forEach>
        </select>
        <select id="raportId">
            <c:forEach var="art" items="${raports}">
                <option value="${art.id}">${art.conclusion}</option>
            </c:forEach>
        </select>
        <select id="reviewerId">
            <c:forEach var="art" items="${reviewers}">
                <option value="${art.id}">${art.fio}</option>
            </c:forEach>
        </select>
        <button type="button" onclick="addAutor()">add autor</button>
        <button type="button" onclick="addKeywords()">add keyword</button>
        <button type="button" onclick="addAnnotation()">add annotation</button>
        <button type="button" onclick="addGrade()">add grade</button>
        <button type="button" onclick="addRaport()">add raport</button>
        <button type="button" onclick="addReviewer()">add reviewer</button>
        <button type="submit">Edit</button>
    </form:form>
    <script>
        function addAutor(){
            var articleid = $("#autorId").val();
            console.log(articleid);
            $.ajax({

                url: "/addAutor",
                data: {articleId: ${id}, autorId: articleid},
                success:function(data){
                    console.log(data);
                }
            });
        }

        function addAnnotation(){
            var articleid = $("#annotationId").val();
            console.log(articleid);
            $.ajax({
                type: "post",
                url: "/addAnnotation",
                data: {articleId: ${id}, annotationId: articleid},
                success:function(data){
                    console.log(data);
                }
            });
        }

        function addGrade(){
            var articleid = $("#gradeId").val();
            console.log(articleid);
            $.ajax({
                url: "/addGrade",
                data: {articleId: ${id}, gradeId: articleid},
                success:function(data){
                    console.log(data);
                }
            });
        }

        function addRaport(){
            var articleid = $("#raportId").val();
            console.log(articleid);
            $.ajax({
                url: "/addRaport",
                data: {articleId: ${id}, raportId: articleid},
                success:function(data){
                    console.log(data);
                }
            });
        }

        function addReviewer(){
            var articleid = $("#reviewerId").val();
            console.log(articleid);
            $.ajax({
                url: "/addReviewer",
                data: {articleId: ${id}, reviewerId: articleid},
                success:function(data){
                    console.log(data);
                }
            });
        }

        function addKeywords(){
            var articleid = $("#keywordsId").val();
            console.log(articleid);
            $.ajax({
                url: "/addKeywords",
                data: {articleId: ${id}, keywordId: articleid},
                success:function(data){
                    console.log(data);
                }
            });
        }
    </script>
</body>
</html>
