<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nasza Baza</title>
</head>
<body>
<%@include file="/header.jsp"%>
<c:url var="home_url" value="/"/>
<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
    </div>
    <center> <h1> Panel Administratora</h1></center><br><br>
    <center><br><h2><a href=admin/all>Lista klientów</a></h2> <br><br>
        <center><br><h2><a href=admin/show>Klient - szczegóły</a></h2> <br><br>
                <br> <h2><a href=admin/institution>Lista instytucji</a> </h2><br><br>
        <br> <h2><a href=admin/new> Dodaj klienta z RODO </a></h2><br><br>
<%@ include file="/footer.jsp" %>
</body>
</html>