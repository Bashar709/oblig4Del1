package no.hvl.dat108.oblig4del1.controller;

import no.hvl.dat108.oblig4del1.model.DeltagerListe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeltagerListeController {

    @GetMapping("/deltagerliste")
    public String visDeltagerliste(Model model){
        model.addAttribute("deltagere", DeltagerListe.hentAlle());
        return "deltagerliste";
    }
}