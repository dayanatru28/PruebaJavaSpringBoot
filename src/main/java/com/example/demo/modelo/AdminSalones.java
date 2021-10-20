package com.example.demo.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="adminSalones")

public class AdminSalones {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "Salones")
	private Salones idSalon;
	@OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "Curso")
	private Curso idCurso;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	private Date hora;
	
	public AdminSalones() {
		super();
	}

	

	public AdminSalones(int id, Salones idSalon, Curso idCurso, Date fecha, Date hora) {
		super();
		this.id = id;
		this.idSalon = idSalon;
		this.idCurso = idCurso;
		this.fecha = fecha;
		this.hora = hora;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Salones getIdSalon() {
		return idSalon;
	}

	public void setIdSalon(Salones idSalon) {
		this.idSalon = idSalon;
	}

	public Curso getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Curso idCurso) {
		this.idCurso = idCurso;
	}



	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	

	
}
