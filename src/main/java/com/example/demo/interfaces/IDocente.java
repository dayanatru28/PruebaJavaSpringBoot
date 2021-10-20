package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.modelo.Docente;

@Repository
public interface IDocente extends CrudRepository<Docente, Integer> {

}
