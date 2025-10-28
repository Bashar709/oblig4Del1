<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String contextPath = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="css/simple.css" rel="stylesheet"/>
    <script src="js/validering.js" defer></script>
    <title>Logg inn</title>
</head>
<body>
<h1>Logg inn</h1>

<!-- Vis flash-feilmelding eller suksessmelding -->
<c:if test="${not empty feilmelding}">
    <p style="color: red; font-weight: bold;">${feilmelding}</p>
</c:if>
<c:if test="${not empty melding}">
    <p style="color: green; font-weight: bold;">${melding}</p>
</c:if>

<!-- Hvis allerede innlogget, vis status og logout-knapp; ellers vis login-skjema -->
<c:choose>
    <c:when test="${not empty sessionScope.deltager}">
        <p>Du er logget inn som: ${sessionScope.deltager.fornavn} ${sessionScope.deltager.etternavn} (${sessionScope.deltager.mobil})</p>
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit">Logg ut</button>
        </form>
    </c:when>
    <c:otherwise>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <fieldset>
                <label>
                    Mobil: <input type="text" name="mobil" id="mobil" pattern="\d{8}" placeholder="Må ha nøyaktig 8 siffer"/>
                </label><br/>
                <label>
                    Passord: <input type="password" name="passord" id="passord"/>
                </label><br/>
                <input type="submit" value="Logg inn"/>
            </fieldset>
        </form>
        <p>Har du ikke konto? <a href="${pageContext.request.contextPath}/paamelding">Meld deg på</a></p>
    </c:otherwise>
</c:choose>

</body>
</html>