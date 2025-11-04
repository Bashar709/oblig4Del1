package no.hvl.dat108.oblig4del1.util;

import no.hvl.dat108.oblig4del1.controller.DeltagerForm;
import no.hvl.dat108.oblig4del1.repo.DeltagerRepository;
import org.springframework.ui.Model;

public class InputValidator {
    public static boolean validerDeltagerForm(DeltagerForm form, Model model, DeltagerRepository deltagerRepository) {
        boolean harFeil = false;

        // Fornavn
        if (form.getFornavn() == null || form.getFornavn().length() < 2 || form.getFornavn().length() > 20) {
            model.addAttribute("feilFornavn", "Fornavn må være mellom 2-20 tegn");
            harFeil = true;
        }

        // Etternavn
        if (form.getEtternavn() == null || form.getEtternavn().length() < 2 || form.getEtternavn().length() > 20) {
            model.addAttribute("feilEtternavn", "Etternavn må være mellom 2-20 tegn");
            harFeil = true;
        }

        // mobilformat og unikhet
        if (form.getMobil() == null || !form.getMobil().matches("\\d{8}")) {
            model.addAttribute("feilMobil", "Ugyldig telefonnummer. Må være 8 siffer");
            harFeil = true;
        }
        // Sjekk om finnes i DB!
        else if (deltagerRepository.existsByMobil(form.getMobil())) {
            model.addAttribute("feilMobil", "Mobilnummeret er allerede registrert");
            harFeil = true;
        }

        // Passord
        if (form.getPassord() == null || form.getPassord().length() < 4 || form.getPassord().length() > 15) {
            model.addAttribute("feilPassord", "Passord må være mellom 4-15 tegn");
            harFeil = true;
        }
        // Sjekk repetert passord
        if (form.getPassord1() == null || !form.getPassord().equals(form.getPassord1())) {
            model.addAttribute("feilPassord1", "Passordene må være like");
            harFeil = true;
        }

        // Kjønn
        if (form.getKjonn() == null || (!form.getKjonn().equals("mann") && !form.getKjonn().equals("kvinne"))) {
            model.addAttribute("feilKjonn", "Velg kjønn");
            harFeil = true;
        }

        return harFeil;
    }
}