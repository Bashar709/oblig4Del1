function sjekkPassordStyrke(passord) {
    if (passord.length === 0) {
        return { tekst: "Skriv passord", farge: "gray" };
    }

    if (passord.length < 4) {
        return { tekst: "For kort", farge: "red" };
    }

    if (passord.length < 6) {
        return { tekst: "Svakt", farge: "red" };
    }

    // Sjekk om har både tall og bokstaver
    const harTall = /\d/.test(passord);
    const harBokstaver = /[a-zA-Z]/.test(passord);

    if (harTall && harBokstaver && passord.length >= 8) {
        return { tekst: "Sterkt", farge: "green" };
    } else if (harTall && harBokstaver) {
        return { tekst: "Bra", farge: "orange" };
    } else {
        return { tekst: "Middels", farge: "orange" };
    }
}
// Funksjon for å vise/skjule passord
function myFunction() {
    const passordInput = document.getElementById('passord');
    const checkbox = document.querySelector('input[type="checkbox"]');

    if (checkbox.checked) {
        passordInput.type = "text";
    } else {
        passordInput.type = "password";
    }
}

// Aktiver live validering
document.addEventListener('DOMContentLoaded', function() {
    const passordInput = document.getElementById('passord');
    const styrkeTekst = document.getElementById('passordStyrke');

    if (passordInput && styrkeTekst) {
        passordInput.addEventListener('input', function() {
            const passord = this.value;
            const resultat = sjekkPassordStyrke(passord);

            styrkeTekst.textContent = resultat.tekst;
            styrkeTekst.style.color = resultat.farge;
        });
    }
});