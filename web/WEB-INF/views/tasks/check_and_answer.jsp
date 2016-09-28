<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Answer</title>
</head>
<body>
    <nav>
        <ul class="top-menu">
            <li><a href="/">TASKS</a></li>
            <li><a href="/learning">LEARNING</a></li>
            <li><a href="/about_us">ABOUT US</a></li>
        </ul>
    </nav>
    <br/><br/>
    <c:choose>
        <c:when test="${responseJSP == true}">
            <form style="background-color: green">
                <br/>
                ${responseJSP}
                <br/><br/>
            </form>
        </c:when>
        <c:otherwise>
            <form style="background-color: red">
                <br/>
                    ${responseJSP}
                <br/><br/>
            </form>
        </c:otherwise>
    </c:choose>
</body>
</html>
