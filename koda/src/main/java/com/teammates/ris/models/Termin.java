package com.teammates.ris.models;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Termin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    //@OneToOne(mappedBy = "termin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //Lokacija lokaciji;

    @OneToOne(mappedBy = "termin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Aktivnost aktivnost;


    //Collection<Komentar> komentar;
    //Collection<Uporabnik> uporabnik;
    private String opis;
    private String zacetek;
    private int stevilo_mest;

    /*public Lokacija getLokaciji() {
        return lokaciji;
    }

    public void setLokaciji(Lokacija lokaciji) {
        this.lokaciji = lokaciji;
    }*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getZacetek() {
        return zacetek;
    }

    public void setZacetek(String zacetek) {
        this.zacetek = zacetek;
    }

    public int getStevilo_mest() {
        return stevilo_mest;
    }

    public void setStevilo_mest(int stevilo_mest) {
        this.stevilo_mest = stevilo_mest;
    }
}