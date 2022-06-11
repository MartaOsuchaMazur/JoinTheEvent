<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show selected client</title>
</head>
<body>
<table border="1">
    <thead>
    <th>firstName</th>
    <th>lastName</th>
    <th>email</th>
    <th>phone</th>
   </thead>
    <tbody>
    <tr>
        <td><c:out value="${clients.firstName}"/></td>
        <td><c:out value="${clients.lastName}"/></td>
        <td><c:out value="${clients.email}"/></td>
        <td><c:out value="${clients.phone}"/></td>
    </tr>
    </tbody>
</table>
</body>
</html>
