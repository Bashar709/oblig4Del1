package no.hvl.dat108.oblig4del1.controller;

import no.hvl.dat108.oblig4del1.model.Deltager;
import no.hvl.dat108.oblig4del1.model.DeltagerListe;
import no.hvl.dat108.oblig4del1.util.InputValider;
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

        boolean harFeil = InputValider.validerDeltager(deltager, model);

        if (harFeil) {
            return "paamelding_med_melding";
        }

        DeltagerListe.leggTil(deltager);
        return "paameldt";
    }
}