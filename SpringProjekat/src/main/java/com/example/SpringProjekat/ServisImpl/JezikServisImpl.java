package com.example.SpringProjekat.ServisImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringProjekat.Model.Jezik;
import com.example.SpringProjekat.Repozitorijumi.JezikRepozitorijum;
import com.example.SpringProjekat.Servis.JezikServis;

@Service
public class JezikServisImpl implements JezikServis {
	
	@Autowired
	JezikRepozitorijum jezikRepozitorijum;

	@Override
	public List<Jezik> nadjiSveJezike() {
		return jezikRepozitorijum.findAll();
	}

	@Override
	public Jezik nadjiJedanJezikPrekoImena(String jezik) {
		return jezikRepozitorijum.nadjiJezikPrekoImena(jezik);
	}

	@Override
	public void sacuvajJezik(Jezik noviJezik) {
		jezikRepozitorijum.save(noviJezik);
		
	}

}
