package koda.src.main.java.com.teammates.ris.models;


import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Lokacija {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String regija;
	private String naslov;


	@OneToMany(mappedBy = "lokacija", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Collection<Uporabnik> uporabnik;

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
}