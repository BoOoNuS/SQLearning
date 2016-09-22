<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Answer</title>
</head>
<body>
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

    <spring:form method="post" action="/task1">
        <input class="submit_button" type="submit" value="Back to task 1"/></br>
    </spring:form>
    <spring:form method="get" action="/">
        <input class="submit_button" type="submit" value="Back to main page"/></br></br>
    </spring:form>
</body>
</html>
