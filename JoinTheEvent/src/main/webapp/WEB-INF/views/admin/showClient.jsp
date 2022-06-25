<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show selected client</title>
</head>
<body>
<table border="1">
    <thead>
    <th>IMIĘ</th>
    <th>NAZWISKO</th>
    <th>INSTYTUCJA</th>
    <th>EMAIL</th>
    <th>TELEFON</th>
    <th>PRZETWARZANIE DANYCH</th>
    <th>OFERTA PRODUKTOWA</th>
    <th>WYDARZENIA</th>
    <th>KONTAKT TEL.</th>
   </thead>
    <tbody>
    <tr>
        <td><c:out value="${clients.firstName}"/></td>
        <td><c:out value="${clients.lastName}"/></td>
        <td><c:out value="${clients.institution.instName}"/></td>
        <td><c:out value="${clients.email}"/></td>
        <td><c:out value="${clients.phone}"/></td>
        <td><c:out value="${clients.marketingConsent.generalConsent}"/></td>
        <td><c:out value="${clients.marketingConsent.productConsent}"/></td>
        <td><c:out value="${clients.marketingConsent.eventConsent}"/></td>
        <td><c:out value="${clients.marketingConsent.phoneConsent}"/></td>
    </tr>
    </tbody>
</table>
</body>
</html>
