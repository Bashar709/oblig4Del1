package no.hvl.dat108.oblig4del1.controller;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.oblig4del1.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @Autowired
    private LoginUtil loginUtil;

    @PostMapping
    public String loggut(HttpSession session, RedirectAttributes ra){
        loginUtil.loggUtBruker(session);
        ra.addFlashAttribute("redirectMessage", "Du er nå logget ut");
        return "redirect:login";
    }
}