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

    public void loggInnBruker(HttpServletRequest request, String mobil) {

        loggUtBruker(request.getSession(false));
        HttpSession sesjon= request.getSession();
        sesjon.setAttribute("mobil", mobil);
        sesjon.setMaxInactiveInterval(60 * 10); // sek 10 min
    }
    public boolean erBrukerInnlogget(HttpSession session){
        return session != null && session.getAttribute("mobil") != null;
    }

    public String getInnloggetMobil(HttpSession session) {
        return session != null ? (String) session.getAttribute("mobil") : null;
    }
}
