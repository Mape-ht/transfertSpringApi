package com.transfert.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transfert.entity.Emetteur;
import com.transfert.services.EmetteurService;


@RestController
public class EmetteurController {
	@Autowired
	private EmetteurService service;

	@GetMapping("/emetteurs")
	public List<Emetteur> list() {
		return service.listAll();
	}

	@GetMapping("/emetteurs/{id}")
	public ResponseEntity<Emetteur> get(@PathVariable Integer id) {
		try {
			Emetteur emetteur = service.get(id);
			return new ResponseEntity<Emetteur>(emetteur, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Emetteur>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/emetteurs/")
	public void add(@RequestBody Emetteur emetteur) {
		service.save(emetteur);
	}

	@PutMapping("/emetteurs/{id}")
	public ResponseEntity<?> update(@RequestBody Emetteur emetteur, @PathVariable Integer id)  {
		try {
		Emetteur existEmetteur = service.get(id);
		service.save(emetteur);

		return new ResponseEntity<>(HttpStatus.OK);
	
		}catch(NoSuchElementException e){
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
	
	@DeleteMapping("/emetteurs/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}
