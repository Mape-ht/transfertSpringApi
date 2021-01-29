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

import com.transfert.entity.Envoi;
import com.transfert.services.EnvoiService;



@RestController
public class EnvoiController {

	@Autowired
	private EnvoiService service;

	@GetMapping("/envois")
	public List<Envoi> list() {
		return service.listAll();
	}

	@GetMapping("/envois/{id}")
	public ResponseEntity<Envoi> get(@PathVariable Integer id) {
		try {
			Envoi envoi = service.get(id);
			return new ResponseEntity<Envoi>(envoi, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Envoi>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/envois/")
	public void add(@RequestBody Envoi envoi) {
		service.save(envoi);
	}

	@PutMapping("/envois/{id}")
	public ResponseEntity<?> update(@RequestBody Envoi envoi, @PathVariable Integer id) {
		try {
			Envoi existEmetteur = service.get(id);
			service.save(envoi);

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/envois/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
