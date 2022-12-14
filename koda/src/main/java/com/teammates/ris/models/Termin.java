package com.teammates.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@Entity
public class Termin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aktivnost")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Aktivnost aktivnost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lokacija")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Lokacija lokacija;

    @OneToMany(mappedBy = "termin", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Collection<Komentar> komentar;

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    public Collection<Komentar> getKomentar() {
        return komentar;
    }

    public void setKomentar(Collection<Komentar> komentar) {
        this.komentar = komentar;
    }

    public Aktivnost getAktivnost() {
        return aktivnost;
    }
    public void setAktivnost(Aktivnost aktivnost) {
        this.aktivnost = aktivnost;
    }


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