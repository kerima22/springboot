package com.pfe.demo.Response;

import java.util.List;

import com.pfe.demo.Entity.Service;

public class JwtResponse {
	 private String token;
	  private String type = "Bearer";
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private Integer idEmploye ;
	private String email ;
	private String matriculeP ;
	private String nom ;
	private String prenom ;
	private Service service;
	private int numTel ;
	private String poste ;
	private String password ;
	private Service Chef;
	private List<String> role;
	
	
	
	public JwtResponse() {
		super();
	}
	
	
	public JwtResponse(String token, String type,Integer idEmploye, String email, String matriculeP, String nom, String prenom,
			Service service ,  int numTel, String poste, String password,Service Chef, List<String> role) {
		super();
		this.token = token;
		this.type = type;
		this.idEmploye = idEmploye;
		this.email = email;
		this.matriculeP = matriculeP;
		this.nom = nom;
		this.prenom = prenom;
		this.service=service;
		this.numTel = numTel;
		this.poste = poste;
		this.password = password;
		this.Chef = Chef;
		this.role = role;
	}
	
	
	public JwtResponse(String jwt, String string, String matriculeP2, String email2, String nom2, String prenom2,
			Service service2, int numTel2, String poste2, Service chef2, String password2, List<String> role2) {
		// TODO Auto-generated constructor stub
	}
	public String getMatriculeP() {
		return matriculeP;
	}
	public void setMatriculeP(String matriculeP) {
		this.matriculeP = matriculeP;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
	public List<String> getRole() {
		return role;
	}
	public void setRoles(List<String> role) {
		this.role = role;
	}
	public Service getChef() {
		return Chef;
	}
	public void setChef(Service chef) {
		Chef = chef;
	}
	public int getIdEmploye() {
		return idEmploye;
	}
	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}
	

}
