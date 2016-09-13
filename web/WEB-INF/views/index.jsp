<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>SQLearning</title>
</head>

<body>
    <spring:form method="post" modelAttribute="queryJSP" action="check-query">
        You SQL query: <spring:input path="query"/></br></br>
        <spring:button>Check SQL</spring:button>
    </spring:form>
</body>

</html>
