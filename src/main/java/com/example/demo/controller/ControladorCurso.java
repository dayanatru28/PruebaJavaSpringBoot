package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.interfaceServices.ICursoServices;
import com.example.demo.interfaceServices.IDocenteServices;
import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Docente;

@Controller
@RequestMapping

public class ControladorCurso {
	@Autowired	
	private ICursoServices service;
	@Autowired
	private IDocenteServices serviceDoc;
	
	//Definir ruta
	@GetMapping("/listarCursos")
	public String listar(Model model) {
		List<Curso> cursos= service.listar();
		//pasa la variable a la vista
		model.addAttribute("cursos", cursos);
		return "cursos";
	}
	
	@GetMapping("/nuevoCurso")
	public String agregar(Model model) {
		List<Docente> docentes= serviceDoc.listar();
		model.addAttribute("docentes",docentes);
		model.addAttribute("curso", new Curso());
		return "formCurso";
	}
	
	@PostMapping("/guardarCurso")
	public String save(@Validated Curso c, Model model, RedirectAttributes redirectAttrs) {
		int var= service.save(c);
		if (var==1) {
			redirectAttrs
            .addFlashAttribute("mensaje", "Agregado correctamente")
            .addFlashAttribute("clase", "success");
		}
		return "redirect:/listarCursos";
	}
	
	@GetMapping("/editarCurso/{codigo}")
	public String editar(@PathVariable String codigo, Model model) {
		List<Docente> docentes= serviceDoc.listar();
		model.addAttribute("docentes",docentes);
		Optional<Curso>curso= service.listarId(codigo);
		model.addAttribute("curso",curso);
		return "formCurso";
	}
	
	@GetMapping("/eliminarCurso/{codigo}")
	public String eliminar(Model model, @PathVariable String codigo,RedirectAttributes redirectAttrs) {
		int var= service.delete(codigo);
		if (var==1) {
			redirectAttrs
            .addFlashAttribute("mensaje", "Eliminado Correctamente")
            .addFlashAttribute("clase", "danger");
		}
		return "redirect:/listarCursos";
	}


}
