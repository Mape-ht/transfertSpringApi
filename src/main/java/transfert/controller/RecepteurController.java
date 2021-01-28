package transfert.controller;

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

import transfert.entity.Emetteur;
import transfert.entity.Recepteur;
import transfert.services.EmetteurService;
import transfert.services.RecepteurService;

@RestController
public class RecepteurController {
	@Autowired
	private RecepteurService service;

	@GetMapping("/recepteurs")
	public List<Recepteur> list() {
		return service.listAll();
	}

	@GetMapping("/recepteurs/{id}")
	public ResponseEntity<Recepteur> get(@PathVariable Integer id) {
		try {
			Recepteur recepteur = service.get(id);
			return new ResponseEntity<Recepteur>(recepteur, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Recepteur>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/recepteurs/")
	public void add(@RequestBody Recepteur recepteur) {
		service.save(recepteur);
	}

	@PutMapping("/recepteurs/{id}")
	public ResponseEntity<?> update(@RequestBody Recepteur recepteur, @PathVariable Integer id)  {
		try {
		Recepteur existRecepteur = service.get(id);
		service.save(recepteur);

		return new ResponseEntity<>(HttpStatus.OK);
	
		}catch(NoSuchElementException e){
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
	
	@DeleteMapping("/recepteurs/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}