<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new Client - Consents</title>
</head>
<body>
<form:form method="post" modelAttribute="clientConsent">

    <c:out value="${client.email}"></c:out> ///
    <c:out value="${client.firstName}"></c:out>
    <c:out value="${client.lastName}"></c:out>

    <div>
        <label for="generalConsent">Zgoda na przetwarzanie danych osobowych</label>
        <form:checkbox path="marketingConsent.generalConsent" name="generalConsent" id="generalConsent"/>
    </div>
    <div>
        <label for="productConsent">Zgoda na informowanie o produktach*</label>
        <form:checkbox path="marketingConsent.productConsent" name="productConsent" id="productConsent"/>
    </div>
    <div>
        <label for="eventConsent">Zgoda na informowanie o wydarzeniach*</label>
        <form:checkbox path="marketingConsent.eventConsent" name="eventConsent" id="eventConsent"/>
    </div>
    <div>
        <label for="phoneConsent">Zgoda na kontakt telefoniczny*</label>
        <form:checkbox path="marketingConsent.phoneConsent" name="phoneConsent" id="phoneConsent"/>
    </div>
    <div>
        <input type="submit" value="Save">
    </div>
</form:form>
</body>
</html>