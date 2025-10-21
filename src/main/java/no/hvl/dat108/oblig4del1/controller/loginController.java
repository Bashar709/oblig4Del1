package no.hvl.dat108.oblig4del1.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {

    @GetMapping("/login")
    public String visLoginSida(){
        return "loginSide";
    }

    @PostMapping("/login")
    public String pselveLogin(@RequestParam String mobil,
                              @RequestParam String passord,
                              HttpSession session){
        session.setAttribute("mobil", mobil);
        session.setAttribute("innlogget", true);

        return "redirect:deltagerliste"; // ← Legg til "redirect:"

    }

}
