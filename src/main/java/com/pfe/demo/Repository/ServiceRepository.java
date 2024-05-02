package com.pfe.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.demo.Entity.Personnel;
import com.pfe.demo.Entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
		
		Optional<Service> deleteByPersonnel(Personnel id);
		
		Optional<Service> findByIdService(Long id);
		
		Optional<Service> deleteByIdService(Long id);
		
		Optional<Service> findByPersonnel(Personnel id);
	}


