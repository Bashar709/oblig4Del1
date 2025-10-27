<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String contextPath = request.getContextPath(); %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<link href="css/simple.css" rel="stylesheet"/>
	<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		&nbsp;&nbsp;&nbsp;${deltager.fornavn}<br />
		&nbsp;&nbsp;&nbsp;${deltager.etternavn}<br />
		&nbsp;&nbsp;&nbsp;${deltager.mobil}<br />
		&nbsp;&nbsp;&nbsp;${deltager.kjonn}<br />

	</p>


	<a href="deltagerliste" class="button1">Gå til deltagerlisten</a>
	<a href="paamelding" class="button1">Tilbake til Påmelding</a>

</body>
</html>