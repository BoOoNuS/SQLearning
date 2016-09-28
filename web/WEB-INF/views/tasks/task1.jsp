<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Task 1</title>
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
    Shame of DB consist of four tables:<br/>
    Product(maker, model, type)<br/>
    PC(code, model, speed, ram, hd, cd, price)<br/>
    Laptop(code, model, speed, ram, hd, price, screen)<br/>
    Printer(code, model, color, type, price)<br/><br/>
    The task:<br/>
    Display all types of product, where maker = 'C'<br/><br/>

    <spring:form method="post" modelAttribute="queryJSP" action="check_and_answer">
        You SQL query:<br/><spring:textarea path="query" id="query"/><br/><br/>
        <spring:button id="btn-6d">Check query</spring:button>
    </spring:form>
</body>
</html>
