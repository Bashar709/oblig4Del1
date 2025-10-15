package no.hvl.dat108.oblig4del1.model;

public class Deltager {

    public Deltager() {}

    private String fornavn;
    private String etternavn;
    private String mobil;
    private String passord;
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

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

    public void setPassord(String passord) {
        this.passord = passord;
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
