<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new Client</title>
</head>
<body>
<form:form method="post" modelAttribute="client">
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
        <input type="submit" value="Save">
    </div>
</form:form>
</body>
</html>