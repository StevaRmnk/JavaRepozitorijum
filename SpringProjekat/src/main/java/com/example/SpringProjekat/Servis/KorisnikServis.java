package com.example.SpringProjekat.Servis;

import java.util.List;

import com.example.SpringProjekat.Model.Korisnik;

public interface KorisnikServis {
	
	List<Korisnik> nadjiSveKorisnike();
	Korisnik nadjiJednogKorisnika(String korisnickoIme);

}
