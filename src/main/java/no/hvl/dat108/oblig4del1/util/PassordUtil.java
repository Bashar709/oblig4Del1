package no.hvl.dat108.oblig4del1.util;

import org.springframework.stereotype.Service;

@Service
public class PassordUtil {

    /**
     * Lagrer passord i klartekst - BARE for testing!
     */
    public static String hashPassord(String passord) {
        return passord; // Ingen hashing - BARE for testing!
    }

    public static boolean sjekkPassord(String passord, String hash) {
        return passord.equals(hash);
    }
}