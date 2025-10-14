<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String contextPath = request.getContextPath(); %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="simple.css">
	<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
<ul>
	<c:forEach var="d" items="${deltagere}">
		<li>${d.kjonn} - ${d.fornavn} - ${d.etternavn} - ${d.mobil}</li>
	</c:forEach>
</ul>

</body>
</html>