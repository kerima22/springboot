package com.pfe.demo.Controller;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.demo.Entity.Conge;

import com.pfe.demo.Entity.Autorisation;
import com.pfe.demo.Entity.Personnel;
import com.pfe.demo.Entity.Service;
import com.pfe.demo.Entity.TypeConge;
import com.pfe.demo.Repository.AutorisationRepository;
import com.pfe.demo.Repository.CongeRepository;
import com.pfe.demo.Repository.TypeCongeRepository;
import com.pfe.demo.Repository.UserRepository;
import com.pfe.demo.Request.DemandeRequest;

import com.pfe.demo.Response.MessageResponse;

@CrossOrigin("*")

@RestController
@RequestMapping("/api/user")
public class UserController {

	  @Autowired
	  UserRepository userRepository;
	  @Autowired
	  CongeRepository congeRepository ;
	  @Autowired
	  TypeCongeRepository typecongeRepository ;
	  @Autowired
	  AutorisationRepository dao;
	   
	  
	  
@PostMapping("/DemandeConge")
public ResponseEntity<?> Demande (@Valid @RequestBody DemandeRequest DemandeRequest){
	Conge conge = new Conge( DemandeRequest.getDateDebut(), DemandeRequest.getDateFin(),
			DemandeRequest.getDuree(), DemandeRequest.getStatut(), DemandeRequest.getCause(),DemandeRequest.getSoldeConge(),DemandeRequest.getDatedemande(),DemandeRequest.getPersonnel(),DemandeRequest.getMatriculeP());
	
	Long InttypeConge  = DemandeRequest.getTypeConge();
	TypeConge typeConge = typecongeRepository.findById(InttypeConge)
            .orElseThrow(() -> new RuntimeException("Error: not found."));
	
	conge.setTypeConge(typeConge);
	congeRepository.save(conge);
	return ResponseEntity.ok(new MessageResponse("okkii"));
    			
}





        
	    @GetMapping("/gett/{mat}")
	    public  Optional<Personnel> get(@PathVariable String mat){
	  	return this.userRepository.findByMatriculeP(mat);
	    }
	    @GetMapping("/getAllp")
		public List<Personnel> getAll(){
		return userRepository.findAll();
		}
	    
	    @GetMapping("/getAllConge")
		public List<Conge> getAlll(){
		return congeRepository.findAll();
		}
	    
	    @GetMapping("/getAllAutorisation")
		public List<Autorisation> getAlll0(){
		return dao.findAll();
		}
	  
		
	    
	    
	    
	    
	    
	    
	    
	    
	   /* @GetMapping("/get/{p}")
	    public  Integer getSolde(@PathVariable Personnel p){
	  	return this.congeRepository.findSoldeCongeByPersonnel(p);
	    }*/
	    
	    
	    @DeleteMapping("delete/{matriculeP}")
	    public ResponseEntity<String> delete(@PathVariable String matriculeP) {
	    	userRepository.deleteByMatriculeP(matriculeP);
	    	return ResponseEntity.ok("Deleted");
	    }
	    
	    @DeleteMapping("Delete/{idEmploye}")
	    public ResponseEntity<String> delete(@PathVariable Integer idEmploye) {
	    	userRepository.deleteById(idEmploye);
	    	return ResponseEntity.ok("Deleted");}
	    
	    @Transactional
	    @DeleteMapping("/supprimerDemande/{idConge}")
	    public ResponseEntity<String> deletee(@PathVariable Long idConge) {
	    	congeRepository.deleteByIdConge(idConge);
	    	return ResponseEntity.ok("Deleted");
	    }
	    
	    
	    
	    @Transactional
	    @DeleteMapping("/fasakh/{idAutorisation}")
	    public ResponseEntity<String> deletee1(@PathVariable Long idAutorisation) {
	    	dao.deleteByIdAutorisation(idAutorisation);
	    	return ResponseEntity.ok("Deleted");
	    }
	    
	 
		/*@GetMapping("getAll/{mat}")
		public List<Conge> getAll(){
		return congeRepository.findAll();
		}*/
	    @CrossOrigin
	    @GetMapping("/getmesconges/{matriculeP}")
	    public List<Conge> getmesconges(@PathVariable("matriculeP") String matriculeP){
	    	return this.congeRepository.findByMatriculeP(matriculeP);
	    }
	    
	    @CrossOrigin
	    @GetMapping("/getmesautorisations/{matriculeP}")
	    public List<Autorisation> getmesautorisations(@PathVariable("matriculeP") String matriculeP){
	    	return this.dao.findByMatriculeP(matriculeP);
	    }
	    
	    @PostMapping("/add")
	    public Personnel addEmpl(@RequestBody Personnel p) 
	    {
	    	return userRepository.save(p);
	    }
	    
	    
	    
	    @PutMapping("/update")
		public Personnel update(@RequestBody Personnel u)  {
				Optional<Personnel> p = userRepository.findByIdEmploye(u.getIdEmploye());
				p.get().setEmail(u.getEmail());
				p.get().setNom(u.getNom());
				p.get().setNumTel(u.getNumTel());
				p.get().setPoste(u.getPoste());
				p.get().setPrenom(u.getPrenom());
				p.get().setService(u.getService());
				p.get().setRole(u.getRole());
				
				Personnel AdminUpdated = userRepository.save(p.get());
				return AdminUpdated;
	    }
	    
	    
		@PutMapping("/updatee")
		public Conge update(@RequestBody Conge u)  {


				Conge conge = congeRepository.findByIdConge(u.getIdConge());
				conge.setDateDebut(u.getDateDebut());
				conge.setDateFin(u.getDateFin());
				conge.setCause(u.getCause());
				conge.setTypeConge(u.getTypeConge());
				Conge CongeUpdated = congeRepository.save(conge);
				return CongeUpdated;

			
			}
		
		@PutMapping("/badel")
		public Autorisation update(@RequestBody Autorisation u)  {


				Optional<Autorisation> autorisation = dao.findByIdAutorisation(u.getIdAutorisation());
				autorisation.get().setHeureSortie(u.getHeureSortie());
				autorisation.get().setHeureRetour(u.getHeureRetour());
				autorisation.get().setMotif(u.getMotif());
				Autorisation AutorisationUpdated = dao.save(autorisation.get());
				return AutorisationUpdated;

			
			}
	    
	    
	   
		@CrossOrigin("http://localhost:4200")
		@PostMapping("/ADD") 
		public Autorisation ajout (@RequestBody Autorisation u) {
//			int sortie = Integer.parseInt(u.getHeureSortie());
//			int retour = Integer.parseInt(u.getHeureRetour());
//
//			int duree = retour-sortie;
//			System.out.println("eeee"+duree);
			String var1=u.getHeureRetour();
			String var2=u.getHeureSortie();
			System.out.println(var1);

System.out.println(var2);
			String [] dateRetour=var1.split(":");
			String [] dateSortie=var2.split(":");

			String minR =dateRetour[0];
			String minS =dateSortie[0];
			String secR =dateRetour[1];
			String secS =dateSortie[1];

			int minsortie = Integer.parseInt(minS);
			int minretour = Integer.parseInt(minR);
			int secsortie = Integer.parseInt(secR);
			int secretour = Integer.parseInt(secS);
			int minDure=minretour-minsortie;
			int secDure=secretour-secsortie;
			System.out.println(minDure);

			String duree = minDure+":"+secDure;
			System.out.println(duree);
	u.setDuree(duree);
			return dao.save(u);
		}
		
		
		@GetMapping("/getId/{matriculeP}")
		public ResponseEntity<Integer> getIdEmployeByMatriculeP(@PathVariable(value = "matriculeP") String matriculeP) throws Exception {
		  Optional<Personnel> personnel = userRepository.findByMatriculeP(matriculeP);
		    Integer idEmploye = personnel.get().getIdEmploye();
		    return ResponseEntity.ok().body(idEmploye);
		}
		
		
		
		
		
		
		
}
