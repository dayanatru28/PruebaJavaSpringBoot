package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceServices.ICursoServices;
import com.example.demo.interfaces.ICurso;
import com.example.demo.modelo.Curso;

@Service
public class CursoServices implements ICursoServices{

	@Autowired
	private ICurso data;
	@Override
	public List<Curso> listar() {
		return (List<Curso>)data.findAll();
	}

	@Override
	public Optional<Curso> listarId(String codigo) {
		return data.findById(codigo);
	}

	@Override
	public int save(Curso p) {
		int res=0;
		Curso curso =data.save(p);
		if(!curso.equals(null)) {
			res=0;
		}
		return 1;
	}

	@Override
	public int delete(String codigo) {
		data.deleteById(codigo);
		return 1;
	}

}
