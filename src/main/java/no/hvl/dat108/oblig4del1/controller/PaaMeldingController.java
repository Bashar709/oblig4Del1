package no.hvl.dat108.oblig4del1.controller;

import no.hvl.dat108.oblig4del1.model.Deltager;
import no.hvl.dat108.oblig4del1.model.DeltagerListe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaaMeldingController {

    @GetMapping("/paamelding")
    public String visSkjema(Model model) {
        model.addAttribute("deltager", new Deltager());
        return "paamelding_med_melding";
    }

    @PostMapping("/paamelding")
    public String taImot(@ModelAttribute("deltager") Deltager deltager, Model model) {

        //sjekke foranavn
        if (deltager.getFornavn() == null || deltager.getFornavn().length() < 2 || deltager.getFornavn().length() > 20) {
            model.addAttribute("feilFornavn", "fornavn må vere mellim 2-20 tegn");
            return "paamelding_med_melding";
        }

        //sjekke etternavn
        if(deltager.getEtternavn()== null || deltager.getEtternavn().length() < 2 || deltager.getEtternavn().length() > 20){
            model.addAttribute("feilEtternavn", "etternavn må vere mellom 2-20 tegn");
            return "paamelding_med_melding";

        }
        //sjekke mobil
        if(deltager.getMobil() == null || !deltager.getMobil().matches("\\d{8}")){
            model.addAttribute("feilMobil", "Ugyldig telefonummerprøv på nytt");
            return "paamelding_med_melding";
        }
        //ingen deltager skal ha likt nummer
        if(DeltagerListe.finnDeltagerMedMobil(deltager.getMobil()) != null){
            model.addAttribute("feilMobilLikt", "mobilnummeret er allerede registrert, prøv på nytt");
            return "paamelding_med_melding";
        }

        //sjekke passord
        if(deltager.getPassord() == null || deltager.getPassord().length() <4 || deltager.getPassord().length() > 15){
            model.addAttribute("feilPassord", "ugyldig passord, prøv på nytt");
            return "paamelding_med_melding";
        }
        // Sjekk at passordene er like
        if (!deltager.getPassord().equals(deltager.getPassord1())) {
            model.addAttribute("feilPassord1", "Passordene må være like");
            return "paamelding_med_melding";
        }

        //sjekke kjønn
        if(deltager.getKjonn() == null){
            model.addAttribute("feilkjonn", "velg kjønn");
            return "paamelding_med_melding";
        }
        DeltagerListe.leggTil(deltager);
        return "paameldt"; //
    }
}
