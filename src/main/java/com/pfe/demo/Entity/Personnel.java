package com.pfe.demo.Entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@Table(name = "Personnel", uniqueConstraints = {
        @UniqueConstraint(columnNames = "matriculeP")
})
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Personnel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEmploye;
	private String email ;
	private String matriculeP ;
	private String nom ;
	private String prenom ;
	private Integer numTel ;
	private String poste ;
	private String password ;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idChefService")
    private Service Chef;
	@ManyToOne
	@JoinColumn(name="service")
	private Service service;
	//@ManyToMany(fetch = FetchType.LAZY)
	//@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	//private Set<Role> roles = new HashSet<>();
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="role")
	private Role role;
	

	
	public Personnel() {
		super();
	}
	public Integer getIdEmploye() {
		return idEmploye;
	}
	public void setIdEmploye(Integer idEmploye) {
		this.idEmploye = idEmploye;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatriculeP() {
		return matriculeP;
	}
	public void setMatriculeP(String matriculeP) {
		this.matriculeP = matriculeP;
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
	
	
	
	
	public Service getChef() {
		return Chef;
	}
	public void setChef(Service chef) {
		Chef = chef;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Integer getNumTel() {
		return numTel;
	}
	public void setNumTel(Integer numTel) {
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
	//public Set<Role> getRoles() {
		//return role;
	//}
	
	public Personnel(Integer idEmploye, String email, String matriculeP,Service service, String nom, String prenom, String departement,
			String nomResponsable, int numTel, String poste, String password, Service Chef, Role role) {
		super();
		this.idEmploye = idEmploye;
		this.email = email;
		this.matriculeP = matriculeP;
		this.nom = nom;
		this.prenom = prenom;
		this.service=service;
		this.numTel = numTel;
		this.poste = poste;
		this.password = password;
		this.Chef=Chef;
		this.role = role;
	}
	public Personnel(String email, String matriculeP, String nom, String prenom, Service service,
			 int numTel, String poste, String password,Service Chef, Role role) {
		super();
		this.email = email;
		this.matriculeP = matriculeP;
		this.nom = nom;
		this.prenom = prenom;
		this.service=service;
		this.numTel = numTel;
		this.poste = poste;
		this.password = password;
		this.Chef=Chef;
		this.role= role;
	}
	public Personnel(String email, String matriculeP, String nom, String prenom,Service service,
			 int numTel, String poste, String password, Service Chef) {
		super();
		this.email = email;
		this.matriculeP = matriculeP;
		this.nom = nom;
		this.prenom = prenom;
		this.service=service;
		this.numTel = numTel;
		this.poste = poste;
		this.password = password;
		this.Chef=Chef;
		
		
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Personnel( String email, String matriculeP, String nom, String prenom, Integer numTel,
			Service service, String poste, String password, Service chef) {
		super();
		this.email = email;
		this.matriculeP = matriculeP;
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
		this.service = service;
		this.poste = poste;
		this.password = password;
		this.Chef = chef;
	}
	
	

	}
