package com.teammates.ris.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Komentar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String komentar;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_uporabnik")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	Uporabnik uporabnik;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_termin")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	Termin termin;

	public Termin getTermin() {
		return termin;
	}

	public void setTermin(Termin termin) {
		this.termin = termin;
	}

	public Uporabnik getUporabnik() { return uporabnik;}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

	public Long getId() { return id;}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKomentar() {
		return komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}
}