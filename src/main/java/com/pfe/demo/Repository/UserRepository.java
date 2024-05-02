package com.pfe.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.demo.Entity.Personnel;



public interface UserRepository extends JpaRepository<Personnel, Integer>{
	 Optional<Personnel> findByNom(String username);
	  Optional<Personnel> findByMatriculeP(String matriculeP);
	  Personnel findByEmail(String email);
	Optional <Personnel> deleteByMatriculeP(String matriculeP);
	Optional<Personnel> findByIdEmploye(Integer idEmploye);
	
	
	

}
