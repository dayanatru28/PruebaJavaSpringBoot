package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceServices.IAdminSalonesServices;
import com.example.demo.interfaceServices.ICursoEstudianteServices;
import com.example.demo.modelo.AdminSalones;
import com.example.demo.modelo.CursoEstudiante;


@Controller
@RequestMapping

public class ControllerAgendaColegio {
	@Autowired
	private IAdminSalonesServices services;
	@Autowired
	private ICursoEstudianteServices servicesCursoEst;
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<AdminSalones> salones= services.listar();
		model.addAttribute("salones", salones);
		return "agendaColegio";

	}
	@GetMapping("/listarEstCurso/{codigo}")
	public String listarEstCurso(@PathVariable String codigo, Model model) {
		List<CursoEstudiante> listado=servicesCursoEst.listarEst(codigo);
		model.addAttribute("listado", listado);
		return "agendaEstCurso";
	}
	
	

}
