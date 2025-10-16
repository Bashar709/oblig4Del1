package no.hvl.dat108.oblig4del1.model;

import java.util.ArrayList;
import java.util.List;

public class DeltagerListe {
    private static List<Deltager>deltagere= new ArrayList<>();
    //sann lista ikkje e null, hadde masse trøbbel ellers

    public static void leggTil(Deltager d){
        deltagere.add(d);
        System.out.println("Detlager lagt til" + d);
    }
    public static List<Deltager> hentAlle() {
        return deltagere;
    }
    public static Deltager finnDeltagerMedMobil(String mobil){
        for(Deltager d: deltagere){
            if(d.getMobil().equals(mobil)){
                return d;
            }
        }
        return null;
    }
}
