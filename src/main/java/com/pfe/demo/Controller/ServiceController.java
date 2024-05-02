package com.pfe.demo.Controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

import com.pfe.demo.Entity.Personnel;
import com.pfe.demo.Entity.Service;
import com.pfe.demo.Repository.ServiceRepository;
import com.pfe.demo.Repository.UserRepository;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/gestionS")
public class ServiceController {
	@Autowired
	private ServiceRepository dao;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping("add")
	public Service ajout(@RequestBody Service service) {
		return dao.save(service);
	}
	
	
	@Transactional
	@DeleteMapping("/delete3/{id}")
	public ResponseEntity<String> deleteid(@PathVariable Personnel id) {
		dao.deleteByPersonnel(id);
		return ResponseEntity.ok("Deleted");
	}
	
	@Transactional
	@DeleteMapping("/delete/{idService}")
	public ResponseEntity<String> deleteidS(@PathVariable Long idService) {
		dao.deleteByIdService(idService);
		return ResponseEntity.ok("Deleted");
	}
	
	
		
	
	@GetMapping("/get1/{id}")
	public Optional<Service> getid(@PathVariable Personnel id) {
		 return dao.findByPersonnel(id);
		
	}
	@GetMapping("/get/{id}")
	public Optional<Service> getid(@PathVariable Long id) {
		 return dao.findByIdService(id);
		
	}
	
	@GetMapping("/getAll")
	public List<Service> getAll(){
	return dao.findAll();
	}
	
	
	@PutMapping("/update")
	public Service update(@RequestBody Service u)  {


			Optional<Service> service = dao.findByIdService(u.getIdService());
			service.get().setNomService(u.getNomService());
			service.get().setPersonnel(u.getPersonnel());
			Service AdminUpdated = dao.save(service.get());
			return AdminUpdated;

		
		}


}
