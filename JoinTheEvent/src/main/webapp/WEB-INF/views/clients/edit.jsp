<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit client</title>
</head>
<body>
<form:form method="post" modelAttribute="client" action="${edit_url}">
    <form:hidden path="id"/>
    <form:input path="firstName"/>
    <form:errors path="firstName"/><br/>
    <form:input path="lastName"/>
    <form:errors path="lastName"/><br/>
    <form:input path="email"/>
    <form:errors path="email"/><br/>
    <form:input path="phone"/>
    <form:errors path="phone"/><br/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
