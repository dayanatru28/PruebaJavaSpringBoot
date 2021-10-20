package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceServices.IAdminSalonesServices;
import com.example.demo.interfaceServices.ISalonesServices;
import com.example.demo.modelo.AdminSalones;
import com.example.demo.modelo.Salones;

@Controller
@RequestMapping
public class ControladorHistorialSalones {
	
	@Autowired
	private IAdminSalonesServices services;
	@Autowired
	private ISalonesServices servicesSalones;
	
	//Definir ruta
	@GetMapping("/buscarSalon/{id}")
	public String listar( Model model, @PathVariable int id) {
		java.util.Date fecha = new Date();
		List<AdminSalones> datosMenores= services.listarReportesMenores(id,fecha);
		model.addAttribute("datosMenores", datosMenores);
		List<AdminSalones> datosMayores= services.listarReportesMayores(id,fecha);
		model.addAttribute("datosMayores", datosMayores);
		return "historial";
	}

}
