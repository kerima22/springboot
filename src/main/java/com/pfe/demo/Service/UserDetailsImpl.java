package com.pfe.demo.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pfe.demo.Entity.Personnel;
import com.pfe.demo.Entity.Role;
import com.pfe.demo.Entity.Service;

import java.util.UUID;


public class UserDetailsImpl implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idEmploye;
	private String email ;
	private String matriculeP ;
	private String nom ;
	private String prenom ;
	private Service service;
	private int numTel ;
	private String poste ;
	private String password ;
	private Service Chef;
	private Collection<? extends GrantedAuthority> authorities;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nom;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
	/*public static UserDetailsImpl build(Personnel user) {
	    List<GrantedAuthority> authorities = user.getRoles().stream()
	        .map(role -> new SimpleGrantedAuthority(role.getNomRole().name()))
	        .collect(Collectors.toList());*/
	public static UserDetailsImpl build(Personnel user) {
	    Role role = user.getRole();
	    List<GrantedAuthority> authorities = Collections.singletonList(
	        new SimpleGrantedAuthority(role.getNomRole().name())
	    );
    return new UserDetailsImpl(
        user.getIdEmploye(), 
        user.getEmail(),
        user.getMatriculeP(),
        user.getNom(),
        user.getPassword(),
        user.getService(),user.getNumTel(),user.getPoste(),user.getPrenom(),authorities,user.getChef() );
}
	

	

	

	
	

	public UserDetailsImpl(Integer idEmploye, String email, String matriculeP, String nom, String password,
			Service service , int numTel, String poste, String prenom, 
			Collection<? extends GrantedAuthority> authorities,Service Chef) {
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
		this.authorities = authorities;

		this.Chef = Chef;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	

	public Integer getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Integer idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getMatriculeP() {
		return matriculeP;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Service getChef() {
		return Chef;
	}

	public void setChef(Service chef) {
		Chef = chef;
	}



	

}