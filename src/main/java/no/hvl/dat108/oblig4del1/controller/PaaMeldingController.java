package no.hvl.dat108.oblig4del1.controller;

import no.hvl.dat108.oblig4del1.model.Deltager;
import no.hvl.dat108.oblig4del1.model.DeltagerListe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaaMeldingController {

    @GetMapping("/paamelding")
    public String visSkjema(){
        return "paamelding_med_melding";
    }

    @PostMapping("/paamelding")
    public String TaImot(@ModelAttribute("deltager") Deltager deltager){
        DeltagerListe.LeggTil(deltager);
        return "paameldt";
    }



}
