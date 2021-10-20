package com.example.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salones")

public class Salones {
	@Id
	private int idSalon;
	private String facultad;
	
	public Salones() {
	}

	public Salones(int idSalon, String facultad) {
		super();
		this.idSalon = idSalon;
		this.facultad = facultad;
	}

	public int getIdSalon() {
		return idSalon;
	}

	public void setIdSalon(int idSalon) {
		this.idSalon = idSalon;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	
	
}
