<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show all clients from database</title>
</head>
<body>
<table border="1">
    <thead>
    <th>firstname</th>
    <th>lastname</th>
    <th>email</th>
    <th>phone</th>
    </thead>
    <tbody>
    <c:forEach items="${clients}" var="client">
        <tr>
            <td><c:out value="${client.firstname}"/></td>
            <td><c:out value="${client.lastname}"/></td>
            <td><c:out value="${client.email}"/></td>
            <td><c:out value="${client.phone}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>