<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj klienta</title>
</head>
<body>
<%@include file="/header.jsp"%>
    <div class="container-fluid">
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
<%--            <h1 class="h3 mb-0 text-gray-800">Nasza baza</h1>--%>
<%--            <a href="<c:url value="/admin/clients/all"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">--%>
<%--                <i class="fas fa-download fa-sm text-white-50"></i>Lista uczestników</a>--%>
        </div>
        <form:form method="post" modelAttribute="clientConsent">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Dodaj klienta z RODO</h6>
            </div>
                  <div class="card-body">
                    <div class="form-group">
                        <label for="firstName">Imię*</label>
                        <form:input path="firstName" id="firstName" type="text" class="form-control"/>
                        <form:errors path="firstName"/>
                    </div>
                    <div class="form-group">
                        <label for="lastName">Nazwisko*</label>
                        <form:input path="lastName" id="lastName" type="text" class="form-control"/>
                        <form:errors path="lastName"/>
                    </div>
                    <div class="form-group">
                        <label for="email">Email*</label>
                        <form:input path="email" id="email" type="email" class="form-control"/>
                        <form:errors path="email"/>
                    </div>
                      <div class="form-group">
                          <label for="phone">Telefon*</label>
                          <form:input path="phone" id="phone" type="text" class="form-control"/>
                          <form:errors path="phone"/>
                      </div>
                      <div class="form-group">
                          <label>Instytucja*</label>
                          <form:select path="institution.id" items="${institutions}" itemLabel="instName" itemValue="id" class="form-control"/>
                          <form:errors path="institution.id"/>
                      </div>
                  <div>
                      <form:input path="id" id="id" type="hidden" value="${id}"/>
                  </div>
                      <div>
                          <p>*pole wymagane</p>
                      </div>
                  <div>
                    <input class="btn btn-primary" type="submit" value="Dalej">
<%--                    <input class="btn btn-primary" type="submit" value="Powrót">--%>
                  </div>
                    </form:form>
            </div>
        </div>
    </div>
<%@ include file="/footer.jsp" %>
</body>
</html>