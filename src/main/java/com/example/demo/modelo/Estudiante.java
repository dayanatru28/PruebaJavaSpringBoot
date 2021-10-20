package com.example.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//Crear la tabla
@Table(name="estudiante")

public class Estudiante {
	//Darle la primary key a la tabla
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombreEstudiante;
	
	public Estudiante() {
	}

	public Estudiante(int id, String nombreEstudiante) {
		super();
		this.id = id;
		this.nombreEstudiante = nombreEstudiante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

}
