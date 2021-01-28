package transfert.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import transfert.entity.Recepteur;

import transfert.repository.RecepteurRepository;

public class RecepteurService {

	@Autowired
	private RecepteurRepository repo;
	
	public List<Recepteur> listAll() {
		return repo.findAll();
	}
	
	public void save(Recepteur recepteur) {
		repo.save(recepteur);
	}

	public Recepteur get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}
