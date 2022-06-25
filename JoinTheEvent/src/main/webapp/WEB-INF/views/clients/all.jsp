<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/header.jsp"%>
<html>
<head>
    <title>Lista klientów</title>
</head>
<body>
<div class="container-fluid">
<div class="d-sm-flex align-items-center justify-content-between mb-4">
                <h1 class="h3 mb-0 text-gray-800">Nasza baza</h1>
                <a href="<c:url value="/admin/clients/add"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                    <i class="fas fa-download fa-sm text-white-50"></i>Dodaj klienta</a>
</div>
<form:form method="get" modelAttribute="clients">
       <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Lista klientów</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <th>Client id</th>
                        <th>firstName</th>
                        <th>lastName</th>
                        <th>email</th>
                        <th>phone</th>
                        <th>institution</th>
                    </tr>
                    <c:forEach items="${clients}" var="client">
                        <tr>
                            <td><c:out value="${client.id}"/></td>
                            <td><c:out value="${client.firstName}"/></td>
                            <td><c:out value="${client.lastName}"/></td>
                            <td><c:out value="${client.email}"/></td>
                            <td><c:out value="${client.phone}"/></td>
                            <td><c:out value="${client.institution.instName}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</form:form>

<%@ include file="/footer.jsp" %>
</body>
</html>