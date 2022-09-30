package com.example.SpringProjekat.Repozitorijumi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.SpringProjekat.Model.Jezik;

public interface JezikRepozitorijum extends JpaRepository<Jezik, Integer>{
	
	@Query(value="select * from jezici where ime_jezika= ?1", nativeQuery = true)
	Jezik nadjiJezikPrekoImena(String imeJezika);

}
