package com.example.SpringProjekat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jezici")
public class Jezik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idJezika",nullable = false)
	private int idJezika;
	
	@Column(name = "imeJezika",nullable = false)
	private String imeJezika;
	
	@Column(name = "vrednost",nullable = false)
	private String vrednost;
	
	public Jezik() {
		
	}
	
	public Jezik(int idJezika,String imeJezika,String vrednost) {
		this.idJezika = idJezika;
		this.imeJezika = imeJezika;
		this.vrednost = vrednost;
	}

	public int getIdJezika() {
		return idJezika;
	}

	public void setIdJezika(int idJezika) {
		this.idJezika = idJezika;
	}

	public String getImeJezika() {
		return imeJezika;
	}

	public void setImeJezika(String imeJezika) {
		this.imeJezika = imeJezika;
	}

	public String getVrednost() {
		return vrednost;
	}

	public void setVrednost(String vrednost) {
		this.vrednost = vrednost;
	}
	
	
	
}
