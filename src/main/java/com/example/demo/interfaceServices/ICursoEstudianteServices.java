package com.example.demo.interfaceServices;
import java.util.List;

import com.example.demo.modelo.CursoEstudiante;

public interface ICursoEstudianteServices {
	
	public List<CursoEstudiante>listar();
	public List<CursoEstudiante> listarEst(String codigo);
	public int save(CursoEstudiante p);
	public int delete(int id);


}
