<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Potwierdzenie</title>
</head>
<body>
<p>
<h3>Uwaga, wybór TAK spowoduje nieodwracalne usunięcie klienta z Naszej Bazy. Kontynuujsz?</h3>
<form method="post">
    <button type="submit" name="confirm" value="yes"><h3>TAK, usuwam klienta z Naszej Bazy</h3></button>
    <button type="submit" name="confirm" value="no"><h3>NIE, rezygnuję z działania</h3></button>
</form>
</p>
<%@ include file="/footer.jsp" %>
</body>
</html>
