package com.teammates.ris.models;

import jakarta.persistence.*;

@Entity
public class Aktivnost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String naziv;
    private String opis;

    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "Aktivnost_termin",
            joinColumns = @JoinColumn(name = "aktivnost_id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id"))
    private Termin termin;

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
