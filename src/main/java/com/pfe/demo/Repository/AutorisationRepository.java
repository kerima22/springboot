package com.pfe.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pfe.demo.Entity.Autorisation;





public interface AutorisationRepository extends JpaRepository<Autorisation, Long> {

	

	Optional<Autorisation> deleteByIdAutorisation(Long idAutorisation);

	Optional<Autorisation> findByIdAutorisation(Long idAutorisation);

	@Query("SELECT a FROM Autorisation a WHERE a.personnel.service.idService = :chefService ORDER BY a.idAutorisation DESC")
	List<Autorisation> getAllAutorisationsByPersonnel(@Param("chefService") Long chefService);

	List<Autorisation> findByMatriculeP(String matriculeP);

	

}
