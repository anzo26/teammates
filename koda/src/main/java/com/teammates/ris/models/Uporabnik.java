package com.teammates.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teammates.ris.models.Lokacija;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Entity
public class Uporabnik {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	private boolean admin = false;
	private String ime;
	private String priimek;
	private String email;
	private String uporabnisko_ime;
	private String geslo;
	private String priljubljeni_sporti;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lokacija")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	Lokacija lokacija;

	public Lokacija getLokacija() {
		return lokacija;
	}

	public void setLokacija(Lokacija lokacija) {
		this.lokacija = lokacija;
	}

	@OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Collection<Komentar> komentarji;


	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPriimek() {
		return priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUporabnisko_ime() {
		return uporabnisko_ime;
	}

	public void setUporabnisko_ime(String uporabnisko_ime) {
		this.uporabnisko_ime = uporabnisko_ime;
	}

	public String getGeslo() {
		return geslo;
	}

	public void setGeslo(String geslo) {
		this.geslo = geslo;
	}

	public String getPriljubljeni_sporti() {
		return priljubljeni_sporti;
	}

	public void setPriljubljeni_sporti(String priljubljeni_sporti) {
		this.priljubljeni_sporti = priljubljeni_sporti;
	}



}