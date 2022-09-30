package com.example.SpringProjekat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "korisnici")
public class Korisnik {
	
	@Id
    @Column(name = "korisnickoIme",unique = true,nullable = false)
    private String korisnicko_ime;
	
	
	@Column(name = "lozinka",nullable = false)
	private String lozinka;
	
	
	@Column(name = "uloga",nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Uloga uloga;
	
	public Korisnik() {
		
	}
	
	
	public Korisnik(String korisnickoIme, String lozinka,Uloga uloga) {
		this.korisnicko_ime = korisnickoIme;
		this.lozinka = lozinka;
		this.uloga = uloga;
	}


	public String getKorisnickoIme() {
		return korisnicko_ime;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnicko_ime = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}


	public Uloga getUloga() {
		return uloga;
	}


	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
	
	
	

}
