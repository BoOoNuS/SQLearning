<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 1</title>
</head>
<body>
    Shame of DB consist of four tables:<br/>
    Product(maker, model, type)<br/>
    PC(code, model, speed, ram, hd, cd, price)<br/>
    Laptop(code, model, speed, ram, hd, price, screen)<br/>
    Printer(code, model, color, type, price)<br/><br/>
    The task:<br/>
    Display all types of product, where maker = 'C'<br/><br/>

    <spring:form method="post" modelAttribute="queryJSP" action="check_and_answer">
        You SQL query: <spring:input path="query"/><br/><br/>
        <spring:button>Check query</spring:button>
    </spring:form>
</body>
</html>
