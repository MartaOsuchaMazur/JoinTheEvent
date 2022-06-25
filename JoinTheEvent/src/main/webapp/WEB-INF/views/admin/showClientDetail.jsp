<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Szczegóły Klienta</title>
</head>
<body>
<%@include file="/header.jsp"%>
<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
    </div>
    <form:form method="post" modelAttribute="clients">
        <%-- <form:select path="client.id" items="${clients}" itemLabel="firstName" itemValue="id"/> --%>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Szczegóły Klienta</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <th>IMIĘ</th>
                        <th>NAZWISKO</th>
                        <th>INSTYTUCJA</th>
                        <th>EMAIL</th>
                        <th>TELEFON</th>
                    </tr>
                    <tr>
                        <td><c:out value="${clients.firstName}"/></td>
                        <td><c:out value="${clients.lastName}"/></td>
                        <td><c:out value="${clients.institution.instName}"/></td>
                        <td><c:out value="${clients.email}"/></td>
                        <td><c:out value="${clients.phone}"/></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    </form:form>
    <div>
        <a href='<c:url value="/admin/show"/>'>Powrót do listy klientów</a>
    </div>
<%@ include file="/footer.jsp" %>
</body>
</html>