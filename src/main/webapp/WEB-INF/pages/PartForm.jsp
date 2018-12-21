<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новая деталь</title>
    <link href="/resources/css/stylePart.css" type="text/css" rel="stylesheet">
    <style>

    </style>
</head>
<body>
<div class="list">
<header>
    <p>Новая деталь</p>
</header>

<form:form action="savePart" method="post" modelAttribute="Part">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Деталь:</td>
                <td><form:input path="detail" /></td>
            </tr>
            <tr>
                <td>Количество:</td>
                <td><form:input path="count" /></td>

            </tr>
            <tr>
                <td>Обязательная:</td>
                <td><form:checkbox path="required" /></td>
            </tr>
            <td>
                <td colspan="2" align="center"><input type="submit" value="Save" ></td></form:form>
            </tr>
            <tr>
                <td colspan="3" align="center"><form:form action="cancel" method="post">
                    <input type="submit" value="Cancel" >

            </form:form></td>
            </tr>
        </table>


</div>
</body>
</html>
