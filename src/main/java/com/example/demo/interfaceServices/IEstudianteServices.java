package com.example.demo.interfaceServices;
import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteServices {
	
	public List<Estudiante>listar();
	//Metodo optional puede devolver o no un valor
	public Optional<Estudiante>listarId(int id);
	public int save(Estudiante p);
	public int delete(int id);

}
