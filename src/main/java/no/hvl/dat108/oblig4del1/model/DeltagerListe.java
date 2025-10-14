package no.hvl.dat108.oblig4del1.model;

import java.util.ArrayList;
import java.util.List;

public class DeltagerListe {
    private static List<Deltager>deltagere= new ArrayList<>();

    public static void leggTil(Deltager d){
        deltagere.add(d);
    }
    public static List<Deltager> hentAlle() {
        return deltagere;
    }
}
