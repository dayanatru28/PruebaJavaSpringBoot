package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Curso;

public interface ICurso extends CrudRepository<Curso, String> {

}
