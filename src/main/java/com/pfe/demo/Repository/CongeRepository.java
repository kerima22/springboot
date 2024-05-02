package com.pfe.demo.Repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.pfe.demo.Entity.Conge;
import com.pfe.demo.Entity.Personnel;

public interface CongeRepository extends JpaRepository <Conge, Long>{
	
	List<Conge> findByPersonnel(Personnel personnel);

		List<Conge> findByMatriculeP(String matriculeP);

		Optional <Conge>deleteByMatriculeP(String matriculeP);

		Optional <Conge> deleteByIdConge(Long idConge);
		
		 
		 
		
		@Query("SELECT c FROM Conge c WHERE c.personnel.service.idService = :chefService ORDER BY c.idConge DESC")
		List<Conge> getAllCongesByPersonnel(@Param("chefService") Long chefService);

		Conge findByIdConge(Long idConge);





	

	

}
