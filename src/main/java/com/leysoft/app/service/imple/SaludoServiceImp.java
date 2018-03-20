package com.leysoft.app.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leysoft.app.entity.Saludo;
import com.leysoft.app.repository.SaludoRepository;
import com.leysoft.app.service.inter.SaludoService;

@Service
public class SaludoServiceImp implements SaludoService {

	@Autowired
	private SaludoRepository saludoRepository;
	
	@Override
	public Saludo save(Saludo saludo) {
		return saludoRepository.save(saludo);
	}

	@Override
	public Saludo findById(Long id) {
		return saludoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Saludo> findAll() {
		return (List<Saludo>) saludoRepository.findAll();
	}

	@Override
	public Saludo update(Saludo saludo) {
		return saludoRepository.save(saludo);
	}

	@Override
	public boolean delete(Long id) {
		boolean delete = false;
		if(findById(id) != null) {
			saludoRepository.deleteById(id);
			delete = true;
		}
		return delete;
	}
}