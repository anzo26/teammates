package com.teammates.ris.models;


import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Lokacija {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String regija;
	private String naslov;
	private int posta;


	@OneToMany(mappedBy = "lokacija", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Collection<Uporabnik> uporabnik;


	public Collection<Uporabnik> getUporabnik() {
		return uporabnik;
	}

	public void setUporabnik(Collection<Uporabnik> uporabnik) {
		this.uporabnik = uporabnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegija() {
		return regija;
	}

	public void setRegija(String regija) {
		this.regija = regija;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public int getPosta() { return posta; }

	public void setPosta(int posta) { this.posta = posta; }
}