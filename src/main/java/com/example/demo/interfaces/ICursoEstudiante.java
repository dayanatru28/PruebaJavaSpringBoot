package com.example.demo.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.CursoEstudiante;

public interface ICursoEstudiante  extends CrudRepository<CursoEstudiante, Integer>{
	List<CursoEstudiante> findByCodigoCursoCodigo(String codigo);

}
