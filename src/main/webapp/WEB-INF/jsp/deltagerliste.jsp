<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String contextPath = request.getContextPath(); %>

<!DOCTYPE html>
<meta charset="UTF-8">

<html>
<head>
	<meta charset="UTF-8">
	<link href="css/simple.css" rel="stylesheet"/>
	<title>Deltagerliste</title>
</head>
<body>
<h2>Deltagerliste</h2>
<table>
	<thead>
	<tr>
		<th>Kjønn</th>
		<th>Navn</th>
		<th>Mobil</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="d" items="${deltagere}">
		<tr>
			<td>
				<c:choose>
					<c:when test="${d.kjonn == 'mann'}">♂</c:when>
					<c:when test="${d.kjonn == 'dame'}">♀</c:when>
					<c:otherwise>${d.kjonn}</c:otherwise>
				</c:choose>
			</td>

			<td>${d.fornavn} ${d.etternavn}</td>
			<td>${d.mobil}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<br>
<a href="paamelding">Tilbake til Påmelding</a>
</body>
</html>