package com.pfe.demo.Controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.demo.Entity.Autorisation;
import com.pfe.demo.Entity.Conge;
import com.pfe.demo.Repository.AutorisationRepository;
import com.pfe.demo.Repository.CongeRepository;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/conge")
public class CongeController {
	
	
	@Autowired
	AutorisationRepository auto;
	@Autowired
	CongeRepository dao;
	
	

   
	  
@GetMapping("/get/{idService}")
public List<Conge> getAll(@PathVariable Long idService){
return dao.getAllCongesByPersonnel(idService);
}

@GetMapping("/jibli/{idService}")
public List<Autorisation> getAlll(@PathVariable Long idService){
return auto.getAllAutorisationsByPersonnel(idService);
}


@PutMapping("/updateee")
public Conge updatee(@RequestBody Conge u)  {


		Conge conge = dao.findByIdConge(u.getIdConge());
		conge.setStatut(u.getStatut());
		conge.setReponse(u.getReponse());
		conge.setGererPar(u.getGererPar());
		Conge CongeUpdated = dao.save(conge);
		return CongeUpdated;
	
	}


@PutMapping("/autoo")
public Autorisation update(@RequestBody Autorisation u)  {


		Optional<Autorisation> autorisation = auto.findByIdAutorisation(u.getIdAutorisation());
		autorisation.get().setStatut(u.getStatut());
		autorisation.get().setReponse(u.getReponse());
		autorisation.get().setGererPar(u.getGererPar());
		Autorisation AutorisationUpdated = auto.save(autorisation.get());
		return AutorisationUpdated;

	
	}



}
