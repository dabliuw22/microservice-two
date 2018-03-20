package com.leysoft.app.service.inter;

import java.util.List;

import com.leysoft.app.entity.Saludo;

public interface SaludoService {
	
	public Saludo save(Saludo saludo);
	
	public Saludo findById(Long id);
	
	public List<Saludo> findAll();
	
	public Saludo update(Saludo saludo);
	
	public boolean delete(Long id);
}