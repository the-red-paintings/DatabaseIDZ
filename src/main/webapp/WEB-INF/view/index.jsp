<%--
  Created by IntelliJ IDEA.
  User: the-red-paintings
  Date: 10.12.2016
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>itNavigator</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        function tableToJSON(){
            var container = new Object();
            container.list = [];
            var list;
            console.log(document.getElementById("list0.fio").value);
            for(i = 0; i <3; i++) {
                var client = {"idClient": document.getElementById("list"+i+".idClient").value,
                "telefone": {"idTelefone": document.getElementById("list"+i+".telefone.idTelefone").value
                    , "number": document.getElementById("list"+i+".telefone.number").value
                    , "type": document.getElementById("list"+i+".telefone.type").value
                    , "comment": document.getElementById("list"+i+".telefone.comment").value
                    }, "fio": document.getElementById("list"+i+".fio").value
                };

                container.list.push(client);

            }
            console.log(JSON.stringify(container));
            return JSON.stringify(container);
        };


        function searchAjax() {
            // Convert the table into a javascript object
            console.log(table);
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "updateAll",
                data : tableToJSON(),
                //dataType : 'json',
                timeout : 100000,
                success : function(data) {
                    console.log("SUCCESS: ", data);

                },
                error : function(e) {
                    console.log("ERROR: ", e);

                },
                done : function(e) {

                }
            });
        }
    </script>
</head>
<body>
<table id="table">
    <thead>
    <form:form method="POST" commandName="container" action="update"  onsubmit="return false">
    <tr>
        <th>FIO</th>
        <th>Number</th>
        <th>Type</th>
        <th>Comment</th>
        <th style="display:none;">TelefoneID</th>
        <th style="display:none;">ClientID</th>
    </tr>
    </thead>

    <c:forEach var="container" items="${container.list}"
               varStatus="status">
        <tr>
            <td><form:input readonly="true"
                            path="list[${status.index}].fio"
                            value="${container.fio}" class="form-control" /></td>
            <td><form:input
                    path="list[${status.index}].telefone.number"
                    value="${container.telefone.number}" class="form-control"/></td>
            <td><form:select
                    path="list[${status.index}].telefone.type">
                    <form:option value="mob">mob</form:option>
                    <form:option value="home">home</form:option>
                    <form:option value="no info">no info</form:option>
                </form:select>
            </td>
            <td><form:input
                    path="list[${status.index}].telefone.comment"
                    value="${container.telefone.comment}" class="form-control"/></td>
            <td><form:input style="display:none;"
                            path="list[${status.index}].idClient"
                            value="${container.idClient}" class="form-control"/>
            </td>
            <td><form:input style="display:none;"
                            path="list[${status.index}].telefone.idTelefone"
                            value="${container.telefone.idTelefone}" class="form-control"/></td>
        </tr>
    </c:forEach>
</table>
<input type="submit" value="Update" class="btn btn-lg btn-success" onclick="searchAjax()">
</form:form>
</body>
</html>
