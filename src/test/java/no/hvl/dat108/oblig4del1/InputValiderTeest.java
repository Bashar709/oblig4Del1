package no.hvl.dat108.oblig4del1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class InputValiderTeest {

    @Test
    public void fornavnTest(){
        String fornavn = "larspetter";
        assertTrue(fornavn.length() >= 2 && fornavn.length() <= 20);
    }

    @Test
    public void etterNavnTest(){
        String etternavn = "Helland";
        assertTrue(etternavn.length() >= 2 && etternavn.length() <= 20);
    }

    @Test
    public void mobilTest(){
        String mobil = "12345678";
        assertTrue(mobil.matches("\\d{8}"));

    }


    @Test
    public void passordMatchTest(){
        String passord= "Dat108";
        String passord1= "Dat108";
        assertTrue(passord.equals(passord1));
    }

    @Test
    public void passordDontMatchTest(){
        String passord= "Dat108";
        String passord1= "Dat100";
        assertFalse(passord.equals(passord1));
    }

    @Test
    public void kjonnTest(){
        String kjonn = "mann";
        assertTrue(kjonn.equals("mann") || kjonn.equals("dame"));
    }


}
