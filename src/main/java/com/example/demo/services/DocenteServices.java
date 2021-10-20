package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceServices.IDocenteServices;
import com.example.demo.interfaces.IDocente;
import com.example.demo.modelo.Docente;

@Service
public class DocenteServices implements IDocenteServices{
	
	@Autowired
	private IDocente data;

	@Override
	public List<Docente> listar() {
		return (List<Docente>)data.findAll();
	}

	@Override
	public Optional<Docente> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Docente d) {
		int res=0;
		Docente docente =data.save(d);
		if(!docente.equals(null)) {
			res=0;
		}
		return 1;
	}

	@Override
	public int delete(int id) {
		data.deleteById(id);
		return 1;
	}

}
