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

import com.example.demo.interfaceServices.ISalonesServices;
import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.Salones;

@Controller
@RequestMapping

public class ControladorSalones {

	@Autowired
	private ISalonesServices service;
	
	//Definir ruta
		@GetMapping("/listarSalones")
		public String listar(Model model) {
			List<Salones> salones= service.listar();
			model.addAttribute("salones", salones);
			return "salones";
		}

		@GetMapping("/nuevoSalon")
		public String agregar(Model model) {
			model.addAttribute("salones", new Salones());
			return "formSalon";
		}
		
		@PostMapping("/guardarSalon")
		public String save(@Validated Salones s, Model model, RedirectAttributes redirectAttrs) {
			int var=service.save(s);
			if (var==1) {
				redirectAttrs
	            .addFlashAttribute("mensaje", "Agregado correctamente")
	            .addFlashAttribute("clase", "success");
			}
			return "redirect:/listarSalones";
		}
		
		
		@GetMapping("/eliminarSalon/{id}")
		public String eliminar(Model model, @PathVariable int id, RedirectAttributes redirectAttrs) {
			int var=service.delete(id);
			if (var==1) {
				redirectAttrs
	            .addFlashAttribute("mensaje", "Eliminado Correctamente")
	            .addFlashAttribute("clase", "danger");
			}
			return "redirect:/listarSalones";
		}
}
