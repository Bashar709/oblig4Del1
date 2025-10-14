package no.hvl.dat108.oblig4del1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeltagerListeController {

    @GetMapping("/deltagerliste")
    public String MeldDeltager(){
        return"deltagerliste";
    }

}
