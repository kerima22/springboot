package com.pfe.demo.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.demo.Entity.EtypeConge;

import com.pfe.demo.Entity.TypeConge;

public interface TypeCongeRepository extends JpaRepository<TypeConge,Long>{
	 Optional<TypeConge> findByNomTypeConge(EtypeConge name  );

	
		
		
	}
	

