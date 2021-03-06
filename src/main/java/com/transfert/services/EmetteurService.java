package com.transfert.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transfert.entity.Emetteur;
import com.transfert.repositories.EmetteurRepository;




@Service
public class EmetteurService {

	@Autowired
	private EmetteurRepository repo;

	public List<Emetteur> listAll() {
		return repo.findAll();
	}

	public void save(Emetteur emetteur) {
		repo.save(emetteur);
	}

	public Emetteur get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
