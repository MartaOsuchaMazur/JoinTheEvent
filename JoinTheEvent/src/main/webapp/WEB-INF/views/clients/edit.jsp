<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit client</title>
</head>
<body>
<c:url var="edit_url" value="/clients/edit/"/>
<form:form method="post" modelAttribute="client" action="${edit_url}">

    <input type="hidden" value="${client.id}" name="id" path="id"  id="id"/>
<div>
    <label for="firstName">Imię</label>
    <input value="${client.firstName}" name="firstName" path="firstName" type="text" id="firstName"/>
</div>
<div>
    <label for="lastName">Nazwisko</label>
    <input value="${client.lastName}"name="lastName" path="lastName" type="text" id="lastName" />
</div>
<div>
    <label for="email">Email</label>
    <input value="${client.email}"name="email" path="email" type="email" id="email" />
</div>
<div>
    <label for="phone">Telefon</label>
    <input value="${client.phone}"name="phone" path="phone" type="text" id="phone" />
</div>
    <div>
        <label>Instytucja</label>
        <input value="${client.institution.id}" name="institution" path="institution.id" type="text" id="insName"/>
    </div>
<div>
    <input type="submit" value="Edit">
</div>
</form:form>
</body>
</html>
