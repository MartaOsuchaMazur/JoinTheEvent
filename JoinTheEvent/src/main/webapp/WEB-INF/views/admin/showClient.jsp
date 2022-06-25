<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pokaż wybranego klienta</title>
</head>
<body>
<%@include file="/header.jsp"%>
<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <%--            <h1 class="h3 mb-0 text-gray-800">Nasza baza</h1>--%>
        <%--            <a href="<c:url value="/admin/clients/all"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">--%>
        <%--                <i class="fas fa-download fa-sm text-white-50"></i>Lista uczestników</a>--%>
    </div>
    <form:form method="post" modelAttribute="clients">
        <%-- <form:select path="client.id" items="${clients}" itemLabel="firstName" itemValue="id"/> --%>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Szczegóły klienta</h6>
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
                        <th>PRZETWARZANIE DANYCH</th>
                        <th>OFERTA PRODUKTOWA</th>
                        <th>WYDARZENIA</th>
                        <th>KONTAKT TELEFONICZNY</th>
                    </tr>
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
                </table>
            </div>
        </div>
    </div>
    </form:form>
    <div>
        <a href='<c:url value="/admin/show"/>'>Powrót do szczegółów</a>
    </div>
<%@ include file="/footer.jsp" %>
</body>
</html>
