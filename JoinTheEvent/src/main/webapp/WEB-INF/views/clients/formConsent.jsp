<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Formularz - zgody</title>
</head>
<body>
<%@include file="/header-reg.jsp"%>
<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <%--            <h1 class="h3 mb-0 text-gray-800">Nasza baza</h1>--%>
        <%--            <a href="<c:url value="/admin/clients/all"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">--%>
        <%--                <i class="fas fa-download fa-sm text-white-50"></i>Lista uczestników</a>--%>
    </div>
    <div>
        <p>Rejestracja na webinarium: Bo uczyć się warto!<br/>
            26 czerwca 2022 roku  11:00 - 12:30 online</p>
    </div>
    <div>
        <p>Prosimy o zapoznanie się i akceptację polityki przetwarzania danych osobowych Naszej firmy.</p><br>
    </div>
    <form:form method="post" modelAttribute="marketingConsent">
        <%-- <form:select path="client.id" items="${clients}" itemLabel="firstName" itemValue="id"/> --%>
    <div>
        <c:out value="${client.firstName}"></c:out>
        <c:out value="${client.lastName}"></c:out> /// <c:out value="${client.email}"></c:out><br>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Zarejestruj się</h6>
        </div>
        <div class="card-body">
            <div class="form-group">
                <label for="generalConsent">Zgoda na przetwarzanie danych osobowych</label>
                <form:checkbox path="generalConsent" name="generalConsent" id="generalConsent" class="form-control"/>
                <form:errors path="generalConsent"/>
            </div>
            <div class="form-group">
                <label for="productConsent">Zgoda na informowanie o produktach</label>
                <form:checkbox path="productConsent" name="productConsent" id="productConsent" class="form-control"/>
                <form:errors path="productConsent"/>
            </div>
            <div class="form-group">
                <label for="eventConsent">Zgoda na informowanie o wydarzeniach</label>
                <form:checkbox path="eventConsent" name="eventConsent" id="eventConsent" class="form-control"/>
                <form:errors path="eventConsent"/>
            </div>
            <div class="form-group">
                <label for="phoneConsent">Zgoda na kontakt telefoniczny</label>
                <form:checkbox path="phoneConsent" name="phoneConsent" id="phoneConsent" class="form-control"/>
                <form:errors path="phoneConsent"/>
            </div>
<%--            <div>--%>
<%--                <form:input path="id" id="id" type="hidden" value="${id}"/>--%>
<%--            </div>--%>
            <div>
                <input class="btn btn-primary" type="submit" value="Zapisz">
            </div>
            </form:form>
        </div>
    </div>
</div>
<%@ include file="/footer.jsp" %>
</body>
</html>