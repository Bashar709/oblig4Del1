package no.hvl.dat108.oblig4del1.model;

public class Deltager {

    private String fornavn;
    private String etternavn;
    private String mobil;
    private String passord;
    private String kjonn;

    public Deltager(String fornavn, String etternavn, String mobil) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.mobil = mobil;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public String getMobil() {
        return mobil;
    }



    @Override
    public String toString() {
        return "Deltager{" +
                "fornavn='" + fornavn + '\'' +
                ", etternavn='" + etternavn + '\'' +
                ", mobil='" + mobil + '\'' +
                ", passord='" + passord + '\'' +
                ", kjonn='" + kjonn + '\'' +
                '}';
    }
}
