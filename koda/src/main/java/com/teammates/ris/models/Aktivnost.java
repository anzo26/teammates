package com.teammates.ris.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Aktivnost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String naziv;
    private String opis;

    @OneToMany(mappedBy = "aktivnost", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Collection<Termin> termin;

    public Collection<Termin> getTermin() {
        return termin;
    }

    public void setTermin(Collection<Termin> termin) {
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

    public String getOpis() { return opis; }

    public void setOpis(String opis) { this.opis = opis; }
}
