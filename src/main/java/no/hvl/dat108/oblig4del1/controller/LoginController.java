package no.hvl.dat108.oblig4del1.controller;

import jakarta.servlet.http.HttpServletRequest;
import no.hvl.dat108.oblig4del1.model.Deltager;
import no.hvl.dat108.oblig4del1.model.DeltagerListe;
import no.hvl.dat108.oblig4del1.util.LoginUtil;
import no.hvl.dat108.oblig4del1.util.PassordUtil;
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

    /*
     * GET /login er forespørselen for å hente login-skjema.
     */
    @GetMapping("/login")
    public String henteLoginSKjema(){
        return "loginSide";
    }

     /*
     * POST /login er forespørselen for å logge inn.
     */
    @PostMapping("/login")
    public String provAaLoggeInn(@RequestParam String mobil,
                                 @RequestParam String passord,
                                 HttpServletRequest request,
                                 RedirectAttributes ra){

        Deltager deltager = DeltagerListe.finnDeltagersMobil(mobil); // finne detlager med mobil

      //sjekke både passord og mobilnummer
        if(deltager == null || PassordUtil.sjekkPassord(passord, deltager.getPassord())){
            ra.addFlashAttribute("feilmelding", "Ugylig mobilnummer eller passord");
            return "redirect:/login";
        }


        loginUtil.loggInnBruker(request, mobil);
        request.getSession().setAttribute("deltager", deltager);
        return "redirect:/deltagerliste";
    }

}
