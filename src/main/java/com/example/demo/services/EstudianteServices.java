package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceServices.IEstudianteServices;
import com.example.demo.modelo.Estudiante;
import com.example.demo.interfaces.IEstudiante;

@Service

public class EstudianteServices implements IEstudianteServices {
	
	@Autowired
	private IEstudiante data;
	@Override
	public List<Estudiante> listar() {
		return (List<Estudiante>)data.findAll();
	}

	@Override
	public Optional<Estudiante> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Estudiante e) {
		int res=0;
		Estudiante estudiante =data.save(e);
		if(!estudiante.equals(null)) {
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
