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


	public Long getId() {
		return id;
	}

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