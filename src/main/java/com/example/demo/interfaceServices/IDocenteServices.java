package com.example.demo.interfaceServices;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Docente;

public interface IDocenteServices {
	
	public List<Docente>listar();
	public Optional<Docente>listarId(int id);
	public int save(Docente d);
	public int delete(int id);

}
