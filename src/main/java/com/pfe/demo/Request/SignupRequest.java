package com.pfe.demo.Request;

import java.util.UUID;

import com.pfe.demo.Entity.Service;

public class SignupRequest {
	private Integer idEmploye;

	private String email ;
	private String nom ;
	private String prenom ;
	private int numTel ;
	private String poste ;
	private String password ;
	private Integer role;
	private Service Chef;

	private Service service;

	public SignupRequest(String email, String matriculeP, String nom, String prenom, 
			Service service, int numTel, String poste, String password , Service Chef) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.service = service;
		this.numTel = numTel;
		this.poste = poste;
		this.service=Chef;
		this.password = password;
	}
	
	public SignupRequest(String email, String matriculeP, String nom, String prenom, 
			Service service, int numTel, String poste, String password, Service Chef, Integer role) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.service=service;
		this.numTel = numTel;
		this.poste = poste;
		this.service=Chef;
		this.password = password;
		this.role = role;
	}

	public SignupRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SignupRequest(Integer idEmploye, String email, String matriculeP, String nom, String prenom,
			Service service, int numTel, String poste, String password, Service Chef, Integer role) {
		super();
		this.idEmploye = idEmploye;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.service = service;
		this.numTel = numTel;
		this.poste = poste;
		this.password = password;
		this.service=Chef;
		this.role = role;
	}
	public  String genererMatricule() {
        UUID uuid = UUID.randomUUID();
        String matriculeP = uuid.toString().substring(0, 5);
        return matriculeP;
    }

	public Integer getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Integer idEmploye) {
		this.idEmploye = idEmploye;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatriculeP() {
		  UUID uuid = UUID.randomUUID();
	        String matriculeP = uuid.toString().substring(0, 5);
		return matriculeP;
	}
	public void setMatriculeP(String matriculeP) {
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public int getNumTel() {
		return numTel;
	}
	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Service getChef() {
		return Chef;
	}

	public void setChef(Service chef) {
		Chef = chef;
	}
	
}
