package com.example.demo.interfaceServices;
import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Curso;

public interface ICursoServices {
	
	public List<Curso>listar();
	public Optional<Curso>listarId(String codigo);
	public int save(Curso p);
	public int delete(String codigo);

}
