<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit client</title>
</head>
<body>
<c:url var="edit_url" value="/clients/"/>
<form:form method="post" modelAttribute="consent" action="${edit_url}">
    <form:hidden path="client.id"/>
    <div>
        <label for="generalConsent">Zgoda na przetwarzanie danych osobowych</label>
        <form:checkbox path="generalConsent" id="generalConsent"/>
    </div>
    <div>
        <label for="productConsent">Zgoda na informowanie o produktach*</label>
        <form:checkbox path="productConsent" id="productConsent"/>
    </div>
    <div>
        <label for="eventConsent">Zgoda na informowanie o wydarzeniach*</label>
        <form:checkbox path="eventConsent" id="eventConsent"/>
    </div>
    <div>
        <label for="phoneConsent">Zgoda na kontakt telefoniczny*</label>
        <form:checkbox path="phoneConsent" id="phoneConsent"/>
    </div>
    <div>
        <input type="submit" value="Save">
    </div>
</form:form>
</body>
</html>
