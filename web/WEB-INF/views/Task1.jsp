<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 1</title>
</head>
<body>
    <spring:form method="post" modelAttribute="queryJSP" action="task1_answer">
        You SQL query: <spring:input path="query"/><br/><br/>
        <spring:button>Check query</spring:button>
    </spring:form>
</body>
</html>
