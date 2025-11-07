package no.hvl.dat108.oblig4del1.controller;

import no.hvl.dat108.oblig4del1.model.Deltager;
import no.hvl.dat108.oblig4del1.model.DeltagerForm;
import no.hvl.dat108.oblig4del1.repo.DeltagerRepository;
import no.hvl.dat108.oblig4del1.service.PassordService;
import no.hvl.dat108.oblig4del1.util.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaaMeldingController {

    @Autowired
    private DeltagerRepository deltagerRepository;

    @Autowired
    private PassordService passordService;

    @GetMapping("/paamelding")
    public String visSkjema(Model model) {
        model.addAttribute("deltager", new DeltagerForm());
        return "paamelding_med_melding";
    }

    @PostMapping("/paamelding")
    public String taImot(@ModelAttribute("deltager") DeltagerForm form, Model model) {

        // Validerer at mobil ikke allerede er brukt, samt alle regler
        boolean harFeil = InputValidator.validerDeltagerForm(form, model, deltagerRepository);

        if (harFeil) {
            return "paamelding_med_melding";
        }

        String salt = passordService.genererTilfeldigSalt();
        String hash = passordService.hashMedSalt(form.getPassord(), salt);

        Deltager deltager = new Deltager(
                form.getMobil(),
                hash,
                salt,
                form.getFornavn(),
                form.getEtternavn(),
                form.getKjonn()
        );
        deltagerRepository.save(deltager);
        return "paameldt";
    }
}