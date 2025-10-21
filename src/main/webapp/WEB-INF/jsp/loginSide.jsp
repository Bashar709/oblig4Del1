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
    <title>loginSide</title>
</head>

<body>
<h1>Logg inn</h1>

<form action="login" method="post">

    <fieldset>
        <label>
            Mobil: <input type="text" name="mobil" id="mobil" pattern="\d{8}" titel="Må ha nøyaktig 8 siffer"
        />

        </label><br>
        <label>
            Passord:
            <input type="password" name="passord" id="passord" placeholder="ditt passord"/>
            <span style="font-size: 0.9em; margin-left: 10px;">
				<input type="checkbox" onclick="passFunksjon()"> Vis passord
			</span>
            <span id="passordStyrke" style="margin-left: 10px; font-weight: bold;"></span>
            <span style="color: red;">${feilPassord}</span><br>
        </label>


        <input type="submit" value="Logg inn"/><br>
    </fieldset>
</form>

</body>
</html>