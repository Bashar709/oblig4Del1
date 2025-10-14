<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>

<html lang="no">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="simple.css" rel="stylesheet"/>
<!-- <script src="js/myscript.js" defer></script>  -->
	<title>PåmeldingSide</title>
</head>

<body>
	<h1>Påmelding</h1>

	<form action="paamelding" method="post">
		<fieldset>
			<label>
				Fornavn: <input type="text" name="fornavn"/>
			</label><br><br>

			<label>
				Etternavn: <input type="text" name="etternavn"/>
			</label><br><br>

			<label>
				Mobil(8 siffer): <input type="text" name="mobil"/>
			</label><br><br>

			<label>
				Passord: <input type="password" name="passord"/>
			</label><br><br>

			<label>
				Gjenta Passord: <input type="password" name="passord1"/>
			</label>

			Kjønn: <br>
			<label>
				<input type="radio" name="kjonn" value="mann"> Mann
				<input type="radio" name="kjonn" value="dame"> Dame
			</label><p>

			<input type="submit" value="meld meg på"/><br>
		</fieldset>
	</form>


</body>
</html>
