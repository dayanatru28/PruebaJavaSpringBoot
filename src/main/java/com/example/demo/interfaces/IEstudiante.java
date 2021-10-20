package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;

@Repository

public interface IEstudiante extends CrudRepository<Estudiante, Integer>{

}
