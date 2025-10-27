package no.hvl.dat108.oblig4del1.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class LoginUtil {
    public void loggUtBruker(HttpSession session){
        if(session != null){
            session.invalidate();
        }
    }

    public void loggInnBruker(HttpServletRequest request, String Mobil) {

        loggUtBruker(request.getSession());

        HttpSession sesjon= request.getSession();
        sesjon.setAttribute("username", Mobil);
        sesjon.setMaxInactiveInterval(30); // sek
    }
    public boolean erBrukerInnlogget(HttpSession session){
        return session != null && session.getAttribute("username") != null;
    }
}
