package sk.upjs.ics.traveltracker;

import java.util.Date;

public class Vylet {
    
    private String krajina;
    private String mesto;
    private String prirodna_a_kulturna_pamiatka;
    private boolean navstivenost;
    private int hodnotenie;
    private String poznamka;
    private String podrobnosti;
    private Date datum;

    public int getHodnotenie() {
        return hodnotenie;
    }

    public void setHodnotenie(int hodnotenie) {
        this.hodnotenie = hodnotenie;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    public String getPodrobnosti() {
        return podrobnosti;
    }

    public void setPodrobnosti(String podrobnosti) {
        this.podrobnosti = podrobnosti;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getKrajina() {
        return krajina;
    }

    public void setKrajina(String krajina) {
        this.krajina = krajina;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getPrirodna_a_kulturna_pamiatka() {
        return prirodna_a_kulturna_pamiatka;
    }

    public void setPrirodna_a_kulturna_pamiatka(String prirodna_a_kulturna_pamiatka) {
        this.prirodna_a_kulturna_pamiatka = prirodna_a_kulturna_pamiatka;
    }

    public boolean isNavstivenost() {
        return navstivenost;
    }

    public void setNavstivenost(boolean navstivenost) {
        this.navstivenost = navstivenost;
    }
    
    
}
