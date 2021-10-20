package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.interfaceServices.ICursoEstudianteServices;
import com.example.demo.interfaceServices.ICursoServices;
import com.example.demo.interfaceServices.IEstudianteServices;
import com.example.demo.modelo.Curso;
import com.example.demo.modelo.CursoEstudiante;
import com.example.demo.modelo.Estudiante;

@Controller
@RequestMapping

public class ControladorCursoEstudiante {
	@Autowired
	private ICursoEstudianteServices service;
	@Autowired
	private ICursoServices serviceCurso;
	@Autowired
	private IEstudianteServices serviceEst;
	
	//Definir ruta
		@GetMapping("/listarCursoEstudiante")
		public String listar(Model model) {
			List<CursoEstudiante> cursosEst= service.listar();
			//pasa la variable a la vista
			model.addAttribute("cursosEst", cursosEst);
			return "cursosEstudiantes";
		}
		
		@GetMapping("/nuevoCursoEst")
		public String agregar(Model model) {
			List<Curso> cursos= serviceCurso.listar();
			List<Estudiante> estudiantes= serviceEst.listar();
			model.addAttribute("cursos", cursos);
			model.addAttribute("estudiantes", estudiantes);
			model.addAttribute("cursoEstudiante", new CursoEstudiante());
			return "formCursoEstudiante";
		}
		
		@PostMapping("/guardarCursoEst/")
		public String save(@Validated CursoEstudiante p, Model model,RedirectAttributes redirectAttrs) {
			int var= service.save(p);
			if (var==1) {
				redirectAttrs
	            .addFlashAttribute("mensaje", "Agregado correctamente")
	            .addFlashAttribute("clase", "success");
			}
			return "redirect:/listarCursoEstudiante";
		}
		
		
		@GetMapping("/eliminarCursoEst/{id}")
		public String eliminar(Model model, @PathVariable int id ,RedirectAttributes redirectAttrs) {
			int var=service.delete(id);
			if (var==1) {
				redirectAttrs
	            .addFlashAttribute("mensaje", "Eliminado Correctamente")
	            .addFlashAttribute("clase", "danger");
			}
			return "redirect:/listarCursoEstudiante";
		}
}
