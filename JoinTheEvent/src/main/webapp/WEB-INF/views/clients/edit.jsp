<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit client</title>
</head>
<body>
<c:url var="edit_url" value="/clients/edit"/>
<form:form method="post" modelAttribute="client" action="${edit_url}">
    <form:hidden path="id"/>
<div>
    <label for="firstName">Imię*</label>
    <form:input path="firstName" id="firstName" type="text"/>
</div>
<div>
    <label for="lastName">Nazwisko*</label>
    <form:input path="lastName" id="lastName" type="text"/>
</div>
<div>
    <label for="email">Email*</label>
    <form:input path="email" id="email" type="email"/>
</div>
<div>
    <label for="phone">Telefon*</label>
    <form:input path="phone" id="phone" type="text"/>
</div>
    <div>
        <label>Instytucja*</label>
        <form:select path="institution.instName" items="${institutions}" itemLabel="instName" itemValue="id"/>
    </div>
<div>
    <input type="submit" value="Save">PRIMARY
</div>
</form:form>
</body>
</html>
