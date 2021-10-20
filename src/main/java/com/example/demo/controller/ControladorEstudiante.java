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

import com.example.demo.interfaceServices.IEstudianteServices;
import com.example.demo.modelo.Estudiante;

@Controller
@RequestMapping

public class ControladorEstudiante {
	
	@Autowired
	//llaman los servicios
	private IEstudianteServices service;
	
	//Definir ruta
	@GetMapping("/listarEstudiantes")
	public String listar(Model model) {
		List<Estudiante> estudiantes= service.listar();
		//pasa la variable a la vista
		model.addAttribute("estudiantes", estudiantes);
		return "estudiantes";
	}

	@GetMapping("/nuevoEstudiante")
	public String agregar(Model model) {
		model.addAttribute("estudiante", new Estudiante());
		return "formEstudiante";
	}
	
	@PostMapping("/guardarEstudiante")
	public String save(@Validated Estudiante e, Model model, RedirectAttributes redirectAttrs) {
		int var= service.save(e);
		if (var==1) {
			redirectAttrs
            .addFlashAttribute("mensaje", "Agregado correctamente")
            .addFlashAttribute("clase", "success");
		}
		return "redirect:/listarEstudiantes";
	}
	
	@GetMapping("/editarEstudiante/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Estudiante>estudiante= service.listarId(id);
		model.addAttribute("estudiante",estudiante);
		return "formEstudiante";
	}
	
	@GetMapping("/eliminarEstudiante/{id}")
	public String eliminar(Model model, @PathVariable int id, RedirectAttributes redirectAttrs) {
		int var= service.delete(id);
		if (var==1) {
			redirectAttrs
            .addFlashAttribute("mensaje", "Eliminado Correctamente")
            .addFlashAttribute("clase", "danger");
		}
		return "redirect:/listarEstudiantes";
	}
}
