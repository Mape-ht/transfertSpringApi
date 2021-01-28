package transfert.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import transfert.entity.Envoi;

import transfert.repository.EnvoiRepository;


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
