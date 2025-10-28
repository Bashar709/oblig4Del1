package no.hvl.dat108.oblig4del1.controller;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.oblig4del1.model.Deltager;
import no.hvl.dat108.oblig4del1.model.DeltagerListe;
import no.hvl.dat108.oblig4del1.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Comparator;

@Controller
public class DeltagerListeController {

    @Autowired
    private LoginUtil loginUtil;


    @GetMapping("/deltagerliste")
    public String visDeltagerliste(HttpSession session, Model model){

        if(!loginUtil.erBrukerInnlogget(session)){
            return "redirect:/login";
        }
        String mobil = loginUtil.getInnloggetMobil(session);
        Deltager innloggetDeltager= DeltagerListe.finnDeltagersMobil(mobil);
        if(innloggetDeltager == null){
            loginUtil.loggUtBruker(session);
            return "redirect:/login";
        }
        session.setAttribute("deltager", innloggetDeltager);

        model.addAttribute("deltagere", DeltagerListe.hentAlle().stream()
                .sorted(Comparator.comparing(Deltager::getFornavn).thenComparing(Deltager::getEtternavn))
                .toList());
        return "deltagerliste";
    }
}