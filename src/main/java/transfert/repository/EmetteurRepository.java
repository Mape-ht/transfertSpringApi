package transfert.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import transfert.entity.Emetteur;

public interface EmetteurRepository extends JpaRepository<Emetteur, Integer>{

	
}
