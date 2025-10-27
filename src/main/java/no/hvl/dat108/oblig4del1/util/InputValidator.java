package no.hvl.dat108.oblig4del1.util;

import no.hvl.dat108.oblig4del1.model.Deltager;
import no.hvl.dat108.oblig4del1.model.DeltagerListe;
import org.springframework.ui.Model;

public class InputValidator {
    public static boolean validerDeltager(Deltager deltager, Model model) {
        boolean harFeil = false;


        //sjekke fornavn
        if (deltager.getFornavn() == null || deltager.getFornavn().length() < 2 || deltager.getFornavn().length() > 20) {
            model.addAttribute("feilFornavn", "Fornavn må være mellom 2-20 tegn");
            harFeil = true;
        }

        //sjekke etternavn
        if (deltager.getEtternavn() == null || deltager.getEtternavn().length() < 2 || deltager.getEtternavn().length() > 20) {
            model.addAttribute("feilEtternavn", "Etternavn må være mellom 2-20 tegn");
            harFeil = true;
        }

        //sjekke mobil format
        if (deltager.getMobil() == null || !deltager.getMobil().matches("\\d{8}")) {
            model.addAttribute("feilMobil", "Ugyldig telefonnummer. Må være 8 siffer");
            harFeil = true;
        }
        //sjekke om mobil allerede eksisterer (kun hvis format er gyldig)
        else if (DeltagerListe.finnDeltagersMobil(deltager.getMobil()) != null) {
            model.addAttribute("feilMobil", "Mobilnummeret er allerede registrert");
            harFeil = true;
        }

        //sjekke passord
        if (deltager.getPassord() == null || deltager.getPassord().length() < 4 || deltager.getPassord().length() > 15) {
            model.addAttribute("feilPassord", "Passord må være mellom 4-15 tegn");
            harFeil = true;
        }

        // Sjekk at passordene er like
        if (!deltager.getPassord().equals(deltager.getPassord1())) {
            model.addAttribute("feilPassord1", "Passordene må være like");
            harFeil = true;
        }

        //sjekke kjønn
        if (deltager.getKjonn() == null) {
            model.addAttribute("feilKjonn", "Velg kjønn");
            harFeil = true;
        }
        return harFeil;
    }
}
