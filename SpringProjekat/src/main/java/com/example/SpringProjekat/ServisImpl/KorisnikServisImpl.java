package com.example.SpringProjekat.ServisImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringProjekat.Model.Korisnik;
import com.example.SpringProjekat.Repozitorijumi.KorisnikRepozitorijum;
import com.example.SpringProjekat.Servis.KorisnikServis;

@Service
public class KorisnikServisImpl implements KorisnikServis {

	@Autowired
	KorisnikRepozitorijum korisnikRepozitorijum;
	
	
	@Override
	public List<Korisnik> nadjiSveKorisnike() {
		return korisnikRepozitorijum.findAll();
	}

	@Override
	public Korisnik nadjiJednogKorisnika(String korisnickoIme) {
		return korisnikRepozitorijum.findById(korisnickoIme).orElseGet(null);
	}

}
