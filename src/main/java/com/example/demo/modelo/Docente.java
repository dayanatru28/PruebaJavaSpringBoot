package com.example.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="docente")

public class Docente {
	
	@Id
	private int idDocente;
	private String nombreDocente;
	
	public Docente() {
	}

	public Docente(int idDocente, String nombreDocente) {
		super();
		this.idDocente = idDocente;
		this.nombreDocente = nombreDocente;
	}

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public String getNombreDocente() {
		return nombreDocente;
	}

	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}
	
	

	
}
