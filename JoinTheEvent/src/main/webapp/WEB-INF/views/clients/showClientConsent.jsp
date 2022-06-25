<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show selected client</title>
</head>
<body>
<%@include file="/header.jsp"%>
<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <%--            <h1 class="h3 mb-0 text-gray-800">Nasza baza</h1>--%>
        <%--            <a href="<c:url value="/admin/clients/all"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">--%>
        <%--                <i class="fas fa-download fa-sm text-white-50"></i>Lista uczestników</a>--%>
    </div>
    <form:form method="post" modelAttribute="marketingConsent">
        <%-- <form:select path="client.id" items="${clients}" itemLabel="firstName" itemValue="id"/> --%>
    <div>
        <c:out value="${client.firstName}"></c:out>
        <c:out value="${client.lastName}"></c:out> /// <c:out value="${client.email}"></c:out>
    </div>
        <div class="card shadow mb-4">
        <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Dziękujemy za udzielone zgody:</h6>
        </div>
        <div class="card-body">
        <div class="table-responsive">
        <table class="table">
        <tr>
        <th>Zgoda na przetwarzanie danych osobowych</th>
        <th>Zgoda na informowanie o produktach</th>
        <th>Zgoda na informowanie o wydarzeniach</th>
        <th>Zgoda na kontakt telefoniczny</th>
        </tr>
            <tr>
                <td>${client.marketingConsent.generalConsent}</td>
                <td>${client.marketingConsent.productConsent}</td>
                <td>${client.marketingConsent.eventConsent}</td>
                <td>${client.marketingConsent.phoneConsent}</td>
            </tr>
        </table>
        </div>
    </div>
</div>
    </form:form>
    <div>
        <a href="">Powrót do strony wydarzenia</a>
    </div>
<%@ include file="/footer.jsp" %>
</body>
</html>
