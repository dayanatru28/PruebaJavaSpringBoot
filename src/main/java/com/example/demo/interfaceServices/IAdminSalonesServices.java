package com.example.demo.interfaceServices;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.AdminSalones;

public interface IAdminSalonesServices {
	
	public List<AdminSalones>listar();
	public Optional<AdminSalones>listarId(int id);
	public List<AdminSalones>listarSalon(int id,Date fecha,Date hora);
	public List<AdminSalones>listarReportesMenores(int id, Date fecha);
	public List<AdminSalones>listarReportesMayores(int id, Date fecha);
	public List<AdminSalones>listarCurso(String codigo,Date fecha,Date hora);
	public int save(AdminSalones p);
	public int delete(int id);

}
