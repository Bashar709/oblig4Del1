package no.hvl.dat108.oblig4del1.controller;

import no.hvl.dat108.oblig4del1.model.Deltager;
import no.hvl.dat108.oblig4del1.model.DeltagerListe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class DeltagerListeController {

    @GetMapping("/deltagerliste")
    public String MeldDeltager(@ModelAttribute Deltager deltager){
        DeltagerListe.leggTil(deltager);
        return"deltagerliste";
    }

}
