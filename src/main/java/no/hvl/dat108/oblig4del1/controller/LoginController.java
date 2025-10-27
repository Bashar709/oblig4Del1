package no.hvl.dat108.oblig4del1.controller;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.oblig4del1.util.InputValidator;
import no.hvl.dat108.oblig4del1.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private InputValidator inputValidator;

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
                              HttpSession session){
        session.setAttribute("mobil", mobil);
        session.setAttribute("innlogget", true);



        return "redirect:deltagerliste";

    }

}
