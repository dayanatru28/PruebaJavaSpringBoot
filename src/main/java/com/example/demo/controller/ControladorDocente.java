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

import com.example.demo.interfaceServices.IDocenteServices;
import com.example.demo.modelo.Docente;

@Controller
@RequestMapping
public class ControladorDocente {
	@Autowired
	private IDocenteServices service;
	
	@GetMapping("/listarDocentes")
	public String listar(Model model) {
		List<Docente> docentes= service.listar();
		model.addAttribute("docentes", docentes);
		return "docentes";
	}

	@GetMapping("/nuevoDocente")
	public String agregar(Model model) {
		model.addAttribute("docente", new Docente());
		return "formDocente";
	}
	
	@PostMapping("/guardarDocente")
	public String save(@Validated Docente d, Model model,RedirectAttributes redirectAttrs) {
		int var=service.save(d);
		if (var==1) {
			redirectAttrs
            .addFlashAttribute("mensaje", "Agregado correctamente")
            .addFlashAttribute("clase", "success");
		}
		return "redirect:/listarDocentes";
	}
	
	@GetMapping("/editarDocente/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Docente>docente= service.listarId(id);
		model.addAttribute("docente",docente);
		return "formDocente";
	}
	
	@GetMapping("/eliminarDocente/{id}")
	public String eliminar(Model model, @PathVariable int id,RedirectAttributes redirectAttrs) {
		int var=service.delete(id);
		if (var==1) {
			redirectAttrs
            .addFlashAttribute("mensaje", "Eliminado Correctamente")
            .addFlashAttribute("clase", "danger");
		}
		return "redirect:/listarDocentes";
	}

}
