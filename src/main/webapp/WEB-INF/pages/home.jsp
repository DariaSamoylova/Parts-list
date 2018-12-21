
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/resources/css/stylePart.css" type="text/css" rel="stylesheet">
    <title>PartsList</title>
</head>

<body>
<div class="list">

        <header>
            <p>Компьютерные комплектующие</p>
        </header>
        <table>
            <tr>
                <td><a href="/partslist/newPart">Создать новую деталь</a></td>
               

            </tr>

        </table>



            <table class="filterTable">
                <tr>
                    <td>Фильтровать:</td>
                    <td><c:set var="filterSt" value="Req"></c:set>
                        <a href="/partslist/filter?filter=${filterSt}">Обязательные</a></td>
                    <td><c:set var="filterSt" value="Opt"></c:set>
                        <a href="/partslist/filter?filter=${filterSt}">Опциональные</a></td>
                    <td><c:set var="filterSt" value="All"></c:set>
                        <a href="/partslist/filter?filter=${filterSt}">Все детали</a></td>

                </tr>
            </table>



    <form method="GET" action="searchId" >

    <table>
    <tr>
                    <td>Поиск по наименованию детали:</td>
        <td><input type="text"   name="detail">    </td>

                    <td> <input type="submit" value="Поиск">    </td>

                </tr>

            </table>

    </form>
        <table>
            <thead>
            <th>Деталь</th>
            <th>Обязательная</th>
            <th>Количество</th>
            <th>Действия</th>
            </thead>

            <c:forEach var="part" items="${allParts}">
                <tr>

                    <td >${part.detail}</td>
                    <td>${part.required}</td>
                    <td>${part.count}</td>

                    <td><a href="/partslist/editPart?id=${part.id}">Редакт.</a>
                        <a href="/partslist/deletePart?id=${part.id}">Удал.</a>


                </tr>
            </c:forEach>
        </table>
        <table>
            <c:set var="amount" value="${amount}"  />
            <tr>
                <td>Можно собрать</td>

                <td>${amount}</td>
                <td>компьютеров</td>
            </tr>
        </table>

           Страница 
            <c:set var="lastPage" value="${count%10}"/>
            <c:set var="pageNum" value="${count/10}"></c:set>
            <c:if test="${lastPage > 0}">
                <c:set var="pageNum" value="${pageNum + 1}"/>
            </c:if>

            <c:forEach begin="1" end="${pageNum}" varStatus="loop">
                <c:choose>
                    <c:when test="${currentPage != loop.count}">
                        <a href="/partslist/paging?pageNum=${loop.count}">${loop.count}</a>
                    </c:when>
                    <c:otherwise>
                        <c:out value="${loop.count}"/>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

</div>
</body>
</html>
