package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.interfaceServices.ICursoEstudianteServices;
import com.example.demo.interfaces.ICursoEstudiante;
import com.example.demo.modelo.CursoEstudiante;

@Service
public class CursoEstudianteServices implements ICursoEstudianteServices {

	@Autowired
	private ICursoEstudiante data;
	@Override
	public List<CursoEstudiante> listar() {
		return (List<CursoEstudiante>)data.findAll();
	}

	@Override
	public int save(CursoEstudiante p) {
		int res=0;
		CursoEstudiante cursoEstudiante =data.save(p);
		if(!cursoEstudiante.equals(null)) {
			res=0;
		}
		return 1;
	}

	@Override
	public int delete(int id) {
		data.deleteById(id);
		return 1;
	}

	@Override
	public List<CursoEstudiante> listarEst(String codigo) {
		return (List<CursoEstudiante>)data.findByCodigoCursoCodigo(codigo);
	}

}
