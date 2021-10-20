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

import com.example.demo.interfaceServices.IAdminSalonesServices;
import com.example.demo.interfaceServices.ICursoServices;
import com.example.demo.interfaceServices.ISalonesServices;
import com.example.demo.modelo.AdminSalones;
import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Salones;

@Controller
@RequestMapping

public class ControladorAdminSalones {
	@Autowired
	private IAdminSalonesServices services;
	@Autowired
	private ISalonesServices servicesSalones;
	@Autowired
	private ICursoServices servicesCurso;
	
	//Definir ruta
		@GetMapping("/listarAdminSalones")
		public String listar(Model model) {
			List<AdminSalones> salones= services.listar();
			model.addAttribute("salones", salones);
			return "adminSalones";
		}
		
		@GetMapping("/nuevoAdminSalones")
		public String agregar(Model model) {
			List<Curso> cursos= servicesCurso.listar();
			model.addAttribute("cursos",cursos);
			List<Salones> salones= servicesSalones.listar();
			model.addAttribute("salones",salones);
			model.addAttribute("adminSalones", new AdminSalones());
			return "formAdminSalones";
		}
		
		@PostMapping("/guardarAdminSalones")
		public String save(@Validated AdminSalones p, Model model,RedirectAttributes redirectAttrs) {
			int var =services.save(p);
			if (var==1) {
				redirectAttrs
	            .addFlashAttribute("mensaje", "Agregado correctamente")
	            .addFlashAttribute("clase", "success");
			}else {
				if (var==2) {
					redirectAttrs
		            .addFlashAttribute("mensaje", "Por favor revisar, mismo curso en salones diferentes")
		            .addFlashAttribute("clase", "danger");
					
				}else {
				redirectAttrs
	            .addFlashAttribute("mensaje", "Por favor revisar, horarios iguales para un mismo salon")
	            .addFlashAttribute("clase", "danger");
			}
				}

			return "redirect:/listarAdminSalones";
		}
		
		@GetMapping("/editarAdminSalones/{id}")
		public String editar(@PathVariable int id, Model model) {
			List<Curso> cursos= servicesCurso.listar();
			model.addAttribute("cursos",cursos);
			List<Salones> salones= servicesSalones.listar();
			model.addAttribute("salones",salones);
			Optional<AdminSalones>adminSalones= services.listarId(id);
			model.addAttribute("adminSalones",adminSalones);
			return "formAdminSalones";
		}
		
		@GetMapping("/eliminarAdminSalones/{id}")
		public String eliminar(Model model, @PathVariable int id,RedirectAttributes redirectAttrs) {
			int var=services.delete(id);
			if (var==1) {
				redirectAttrs
	            .addFlashAttribute("mensaje", "Eliminado Correctamente")
	            .addFlashAttribute("clase", "success");
			}
			
			return "redirect:/listarAdminSalones";
		}

}
