<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String contextPath = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="no">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="css/simple.css" rel="stylesheet"/>
	<script src="js/validering.js" defer></script>
	<title>PåmeldingSide</title>
</head>

<body>
<h1>Påmelding</h1>

<c:if test="${not empty feilmelding}">
	<p style="color: red; font-weight: bold;">${feilmelding}</p>
</c:if>

<form action="paamelding" method="post" id="paameldingSkjema">


	<fieldset>

		<label>
			Fornavn: <input type="text" name="fornavn" id="forNavn"
							pattern="[A-ZÆØÅa-zæøå\s\-]{2,20}"
							title="Kun bokstaver, bindestrek og mellomrom. 2-20 tegn."/>
			<span style="color: red;">${feilFornavn}</span><br>
		</label><br>

		<label>
			Etternavn: <input type="text" name="etternavn" id="etterNavn"
							  pattern="[A-ZÆØÅa-zæøå\s\-]{2,20}"
							  title="Kun bokstaver, bindestrek og mellomrom. 2-20 tegn."/>
			<span style="color: red;">${feilEtternavn}</span><br>
		</label><br>

		<label>
			Mobil: <input type="text" name="mobil" id="mobilNR"/>
			<span style="color: red;">${feilMobil}</span><br>
		</label><br>

		<label>
			Passord: <input type="password" name="passord" id="passord"/>
			<span style="font-size: 0.9em; margin-left: 10px;">
				<input type="checkbox" onclick="passFunksjon()"> Vis passord
			</span>
			<span id="passordStyrke" style="margin-left: 10px; font-weight: bold;"></span>
			<span style="color: red;">${feilPassord}</span><br>
		</label><br>

		<label>
			Gjenta Passord: <input type="password" name="passord1" id="gjentaPassord"/>
			<span style="color: red;">${feilPassord1}</span><br>

		</label>

		<fieldset>
			<legend>Kjønn: </legend>
			<label>
				<input type="radio" name="kjonn" value="mann" id="mann"> Mann
				<input type="radio" name="kjonn" value="dame" id="dame"> Dame
			</label>
		</fieldset>
		<span style="color: red;">${feilKjonn}</span><br>

		<input type="submit" value="meld meg på"/><br>
	</fieldset>
</form>

</body>
</html>