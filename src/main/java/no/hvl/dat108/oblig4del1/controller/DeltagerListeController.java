package no.hvl.dat108.oblig4del1.controller;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.oblig4del1.model.Deltager;
import no.hvl.dat108.oblig4del1.repo.DeltagerRepository;
import no.hvl.dat108.oblig4del1.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Comparator;
import java.util.List;

@Controller
public class DeltagerListeController {

    @Autowired
    private LoginUtil loginUtil;

    @Autowired
    private DeltagerRepository deltagerRepository;

    @GetMapping("/deltagerliste")
    public String visDeltagerliste(HttpSession session, Model model) {
        if (!loginUtil.erBrukerInnlogget(session)) {
            return "redirect:/login";
        }
        String mobil = loginUtil.getInnloggetMobil(session);
        Deltager innloggetDeltager = deltagerRepository.findByMobil(mobil);
        if (innloggetDeltager == null) {
            loginUtil.loggUtBruker(session);
            return "redirect:/login";
        }
        session.setAttribute("deltager", innloggetDeltager);

        // Hent fra database og sorter som før
        List<Deltager> deltagere = deltagerRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Deltager::getFornavn).thenComparing(Deltager::getEtternavn))
                .toList();
        model.addAttribute("deltagere", deltagere);
        model.addAttribute("innloggetMobil", mobil);
        return "deltagerliste";
    }
}