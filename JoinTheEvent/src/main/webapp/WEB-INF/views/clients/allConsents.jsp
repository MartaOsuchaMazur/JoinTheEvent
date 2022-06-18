<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show all client's consents</title>
</head>
<body>
<table border="1">
    <thead>
    <th>firstName</th>
    <th>lastName</th>
    <th>institution</th>
    <th>generalConsent</th>
    <th>productConsent</th>
    <th>eventConsent</th>
    <th>phoneConsent</th>
    </thead>
    <tbody>
    <c:forEach items="${consent}" var="consent">
        <tr>
            <td><c:out value="${consent.client.firstName}"/></td>
            <td><c:out value="${consent.client.lastName}"/></td>
            <td><c:out value="${consent.client.institution.instName}"/></td>
            <td><c:out value="${consent.generalConsent}"/></td>
            <td><c:out value="${consent.productConsent}"/></td>
            <td><c:out value="${consent.eventConsent}"/></td>
            <td><c:out value="${consent.phoneConsent}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>