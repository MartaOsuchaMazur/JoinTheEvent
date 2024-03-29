<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Zgody Klienta</title>
</head>
<body>
<%@include file="/header-reg.jsp"%>
<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
    </div>
    <form:form method="post" modelAttribute="marketingConsent">
        <%-- <form:select path="client.id" items="${clients}" itemLabel="firstName" itemValue="id"/> --%>
    <div>
        <c:out value="${client.firstName}"></c:out>
        <c:out value="${client.lastName}"></c:out> /// <c:out value="${client.email}"></c:out><br>
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
        <a href="http://localhost:8080/JoinTheEvent/">Powrót do strony wydarzenia</a>
    </div>
<%@ include file="/footer.jsp" %>
</body>
</html>