package no.hvl.dat108.oblig4del1.controller;

import jakarta.servlet.http.HttpServletRequest;
import no.hvl.dat108.oblig4del1.model.Deltager;
import no.hvl.dat108.oblig4del1.repo.DeltagerRepository;
import no.hvl.dat108.oblig4del1.service.PassordService;
import no.hvl.dat108.oblig4del1.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private LoginUtil loginUtil;

    @Autowired
    private DeltagerRepository deltagerRepository;

    @Autowired
    private PassordService passordService;

    // GET /login - viser login-skjema
    @GetMapping("/login")
    public String henteLoginSKjema() {
        return "loginSide";
    }

    // POST /login - forsøker å logge inn
    @PostMapping("/login")
    public String provAaLoggeInn(
            @RequestParam String mobil,
            @RequestParam String passord,
            HttpServletRequest request,
            RedirectAttributes ra) {

        Deltager deltager = deltagerRepository.findByMobil(mobil);

        if (deltager == null ||
                !passordService.erKorrektPassord(passord, deltager.getSalt(), deltager.getHash())) {
            ra.addFlashAttribute("feilmelding", "Ugyldig mobil eller passord");
            return "redirect:/login";
        }

        loginUtil.loggInnBruker(request, mobil);
        request.getSession().setAttribute("deltager", deltager);

        return "redirect:/deltagerliste";
    }
}