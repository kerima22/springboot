package com.pfe.demo.Entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="Autorisation")
public class Autorisation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  idAutorisation ; 
	
	private String heureSortie;
	
	private String heureRetour ;
	private String Motif;
	private String Duree;
	private String statut;
	private String matriculeP ;
	private String reponse ;
	private String gererPar;
	@ManyToOne
	@JoinColumn(name="idEmploye")
	private Personnel personnel;
	
	

	
	
	

	

	public Autorisation() {
		// TODO Auto-generated constructor stub
	}
	
	

	











	public Autorisation(Long idAutorisation, String heureSortie, String heureRetour, String motif, String duree,
			String statut, String matriculeP, String reponse, String gererPar, Personnel personnel) {
		super();
		this.idAutorisation = idAutorisation;
		this.heureSortie = heureSortie;
		this.heureRetour = heureRetour;
		Motif = motif;
		Duree = duree;
		this.statut = statut;
		this.matriculeP = matriculeP;
		this.reponse = reponse;
		this.gererPar = gererPar;
		this.personnel = personnel;
	}




	public String getReponse() {
		return reponse;
	}




	public void setReponse(String reponse) {
		this.reponse = reponse;
	}




	public String getGererPar() {
		return gererPar;
	}


	public void setGererPar(String gererPar) {
		this.gererPar = gererPar;
	}




	public Long getIdAutorisation() {
		return idAutorisation;
	}

	public void setIdAutorisation(Long idAutorisation) {
		this.idAutorisation = idAutorisation;
	}

	

	public String getStatut() {
		return statut;
	}






	public void setStatut(String statut) {
		this.statut = statut;
	}



	public String getMatriculeP() {
		return matriculeP;
	}




	public void setMatriculeP(String matriculeP) {
		this.matriculeP = matriculeP;
	}



	public String getHeureSortie() {
		return heureSortie;
	}

	public void setHeureSortie(String heureSortie) {
		this.heureSortie = heureSortie;
	}

	public String getHeureRetour() {
		return heureRetour;
	}

	public void setHeureRetour(String heureRetour) {
		this.heureRetour = heureRetour;
	}

	public String getMotif() {
		return Motif;
	}

	public void setMotif(String motif) {
		Motif = motif;
	}

	public String getDuree() {
		return Duree;
	}

	public void setDuree(String duree) {
		Duree = duree;
	}

	

	
	

	public Personnel getPersonnel() {
		return personnel;
	}






	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}






	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
