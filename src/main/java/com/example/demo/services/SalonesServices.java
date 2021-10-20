package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceServices.ISalonesServices;
import com.example.demo.interfaces.ISalones;
import com.example.demo.modelo.Salones;

@Service

public class SalonesServices implements ISalonesServices {
	
	@Autowired
	private ISalones data;
	@Override
	public List<Salones> listar() {
		return (List<Salones>)data.findAll();
	}

	@Override
	public Optional<Salones> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Salones s) {
		int res=0;
		Salones salones =data.save(s);
		if(!salones.equals(null)) {
			res=0;
		}
		return 1;
	}

	@Override
	public int delete(int id) {
		data.deleteById(id);
		return 1;
	}

}
