package com.example.demo.interfaceServices;
import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Salones;

public interface ISalonesServices {
	public List<Salones>listar();
	public Optional<Salones>listarId(int id);
	public int save(Salones s);
	public int delete(int id);

}
