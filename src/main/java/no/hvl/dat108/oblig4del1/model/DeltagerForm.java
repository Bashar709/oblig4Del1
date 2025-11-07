package no.hvl.dat108.oblig4del1.model;

public class DeltagerForm {
    private String fornavn;
    private String etternavn;
    private String mobil;
    private String passord;
    private String passord1; // repetert passord for validering i skjema
    private String kjonn; // "mann" eller "kvinne"

    // Husk tom konstruktør hvis du bruker @ModelAttribute
    public DeltagerForm() {}

    // Getters og setters
    public String getFornavn() { return fornavn; }
    public void setFornavn(String fornavn) { this.fornavn = fornavn; }

    public String getEtternavn() { return etternavn; }
    public void setEtternavn(String etternavn) { this.etternavn = etternavn; }

    public String getMobil() { return mobil; }
    public void setMobil(String mobil) { this.mobil = mobil; }

    public String getPassord() { return passord; }
    public void setPassord(String passord) { this.passord = passord; }

    public String getPassord1() { return passord1; }
    public void setPassord1(String passord1) { this.passord1 = passord1; }

    public String getKjonn() { return kjonn; }
    public void setKjonn(String kjonn) { this.kjonn = kjonn; }
}
