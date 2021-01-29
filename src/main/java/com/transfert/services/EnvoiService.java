package com.transfert.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transfert.entity.Envoi;
import com.transfert.repositories.EnvoiRepository;





@Service
public class EnvoiService {

	@Autowired
	private EnvoiRepository repo;
	
	public List<Envoi> listAll() {
		return repo.findAll();
	}
	
	public void save(Envoi envoi) {
		repo.save(envoi);
	}

	public Envoi get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	
}
