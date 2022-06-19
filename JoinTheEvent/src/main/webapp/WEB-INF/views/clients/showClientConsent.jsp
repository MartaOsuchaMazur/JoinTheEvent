<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show selected client</title>
</head>
<body>
<table border="1">
    <thead>
    <th>generalConsent</th>
    <th>productConsent</th>
    <th>eventConsent</th>
    <th>phoneConsent</th>
   </thead>
    <tbody>
<c:out value="${client.email}"></c:out> ///
<c:out value="${client.firstName}"></c:out>
<c:out value="${client.lastName}"></c:out>
    <tr>
        <td><c:out value="${client.marketingConsent.generalConsent}"/></td>
        <td><c:out value="${client.marketingConsent.productConsent}"/></td>
        <td><c:out value="${client.marketingConsent.eventConsent}"/></td>
        <td><c:out value="${client.marketingConsent.phoneConsent}"/></td>
    </tr>
    </tbody>
</table>
</body>
</html>
