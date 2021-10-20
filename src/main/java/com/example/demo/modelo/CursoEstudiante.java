package com.example.demo.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="curso_estudiante")

public class CursoEstudiante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "Curso")
	private Curso codigoCurso;
	@ManyToOne(cascade = CascadeType.REFRESH)
	//, referencedColumnName = "id"
    @JoinColumn(name = "Estudiante")
	private Estudiante idEstudiante;
	
	
	
	public CursoEstudiante() {
	}

	public CursoEstudiante(int id, Curso codigoCurso, Estudiante idEstudiante) {
		super();
		this.id = id;
		this.codigoCurso = codigoCurso;
		this.idEstudiante = idEstudiante;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Curso getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(Curso codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public Estudiante getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Estudiante idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	

	
}
