<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista klientów</title>
</head>
<body>
<%@include file="/header.jsp"%>
<div class="container-fluid">
    <br>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
                <h1 class="h3 mb-0 text-gray-800"></h1>
                <a href="<c:url value="/admin/new"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
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
                        <th>ID</th>
                        <th>IMIĘ</th>
                        <th>NAZWISKO</th>
                        <th>INSTYTUCJA</th>
                        <th>POKAŻ KLIENTA</th>
                        <th>USUŃ KLIENTA</th>
                    </tr>
                    <c:forEach items="${clients}" var="client">
                        <tr>
                            <td><c:out value="${client.id}"/></td>
                            <td><c:out value="${client.firstName}"/></td>
                            <td><c:out value="${client.lastName}"/></td>
                            <td><c:out value="${client.institution.instName}"/></td>
                            <td><a href="/admin/get/${client.id}">Pokaż</a></td>
                            <td><a href="/admin/delete/${client.id}">Usuń</a></td>
<%--                                <a href='<c:url value="/user/edit?id=${user.id}"/>'>Edit</a>--%>
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