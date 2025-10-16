package no.hvl.dat108.oblig4del1.model;

public class Deltager {

    public Deltager() {}

    private String fornavn;
    private String etternavn;
    private String mobil;
    private String passord;
    private String passord1;
    private String kjonn;

    public Deltager(String fornavn, String etternavn, String mobil, String passord, String kjonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.mobil = mobil;
        this.passord=passord;
        this.kjonn=kjonn;
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
    public String getPassord(){return passord;}
    public String getPassord1(){return passord1;}


    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public void setPassord1(String passord1) {
        this.passord1 = passord1;
    }


    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

}
