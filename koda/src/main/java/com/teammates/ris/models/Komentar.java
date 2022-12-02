package koda.src.main.java.com.teammates.ris.models;


import jakarta.persistence.*;

@Entity
public class Komentar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String komentar;


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