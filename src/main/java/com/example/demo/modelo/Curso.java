package com.example.demo.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso {
	
	@Id
	private String codigo;
	private String nombreCurso;
	@OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "Docente")
	private Docente idDocente;
	
	
	public Curso() {
	}


	public Curso(String codigo, String nombreCurso, Docente idDocente) {
		super();
		this.codigo = codigo;
		this.nombreCurso = nombreCurso;
		this.idDocente = idDocente;
	}



	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}


	public Docente getIdDocente() {
		return idDocente;
	}


	public void setIdDocente(Docente idDocente) {
		this.idDocente = idDocente;
	}
	
	

}
