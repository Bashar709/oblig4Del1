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
<c:choose>
	<c:when test="${not empty sessionScope.deltager}">
		<p>Innlogget som: ${sessionScope.deltager.fornavn} ${sessionScope.deltager.etternavn} (${sessionScope.deltager.mobil})</p>
	</c:when>
	<c:otherwise>
		<p>Du er ikke logget inn. <a href="login">Logg inn</a> eller <a href="paamelding">Meld deg på</a> for å se hele listen.</p>
	</c:otherwise>
</c:choose>

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
	<tr>
		<td>♂</td>
		<td>Lars-Petter Healand</td>
		<td>12345678</td>
	</tr>

	<tr>
		<td>♂</td>
		<td>Erling Braut Haaland</td>
		<td>12345678</td>
	</tr>

	<tr>
		<td>♂</td>
		<td>Andreas Ødegård</td>
		<td>12345678</td>
	</tr>




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
<a href="paamelding" class="button1">Tilbake til Påmelding</a>
<a href="login"class="button1">Logg ut!</a>

</body>
</html>