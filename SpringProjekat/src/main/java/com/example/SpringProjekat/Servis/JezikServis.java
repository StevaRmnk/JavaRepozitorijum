package com.example.SpringProjekat.Servis;

import java.util.List;

import com.example.SpringProjekat.Model.Jezik;

public interface JezikServis {
	
	List<Jezik> nadjiSveJezike();
	Jezik nadjiJedanJezikPrekoImena(String jezik);
	void sacuvajJezik(Jezik noviJezik);

}
