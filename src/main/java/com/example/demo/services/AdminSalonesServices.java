package com.example.demo.services;

import java.util.List;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.interfaceServices.IAdminSalonesServices;
import com.example.demo.interfaces.IAdminSalones;
import com.example.demo.modelo.AdminSalones;
import com.example.demo.modelo.Curso;
import com.example.demo.modelo.CursoEstudiante;

@Service

public class AdminSalonesServices implements IAdminSalonesServices {
	@Autowired
	private IAdminSalones data;
	@Autowired
	private IAdminSalonesServices services;

	@Override
	public List<AdminSalones> listar() {
		return (List<AdminSalones>) data.findAll();
	}

	@Override
	public Optional<AdminSalones> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public List<AdminSalones> listarSalon(int idSalon, Date fecha, Date hora) {
		return data.findByIdSalonIdSalonAndFechaAndHora(idSalon, fecha, hora);
	}

	@Override
	public List<AdminSalones> listarCurso(String codigo, Date fecha, Date hora) {
		return data.findByIdCursoCodigoAndFechaAndHora(codigo, fecha, hora);
	}

	@Override
	public int save(AdminSalones p) {
		int id = (p.getIdSalon().getIdSalon());
		String codigo = (p.getIdCurso().getCodigo());
		Date fecha = (p.getFecha());
		Date hora = (p.getHora());

		List<AdminSalones> salones = services.listarSalon(id, fecha, hora);
		List<AdminSalones> cursos = services.listarCurso(codigo, fecha, hora);

		if (salones.size() != 0) {
			return 0;
		} else {

			if (cursos.size() != 0) {
				return 2;
			} else {
				AdminSalones adminSalones = data.save(p);
				if (!adminSalones.equals(null)) {
					return 1;
				}
				return 1;
			}
		}

	}

	@Override
	public int delete(int id) {
		data.deleteById(id);
		return 1;

	}

	@Override
	public List<AdminSalones> listarReportesMenores(int id, Date fecha) {
		return data.findByIdSalonIdSalonAndFechaLessThan(id,fecha);
	}
	
	@Override
	public List<AdminSalones> listarReportesMayores(int id, Date fecha) {
		return data.findByIdSalonIdSalonAndFechaGreaterThanEqual(id,fecha);
	}
}
