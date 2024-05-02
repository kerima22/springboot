package com.pfe.demo.Request;

import java.sql.Date;

import com.pfe.demo.Entity.Personnel;



public class DemandeRequest {
	private Date dateDebut  ;
	private  Date dateFin ;
	private int duree;
	private String statut ;
	private String Cause;
	private int soldeConge;
	private Long typeConge;
	private Date datedemande;
	private Personnel personnel;
	private String matriculeP;
	
	
	public DemandeRequest() {
		// TODO Auto-generated constructor stub
	}
	
	


	public DemandeRequest(Date dateDebut, Date dateFin, int duree, String statut, String cause,int soldeConge, Long typeConge , Date datedemande , Personnel personnel, String matriculeP) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.duree = duree;
		this.statut = statut;
		this.Cause = cause;
		this.soldeConge = soldeConge;
		this.typeConge = typeConge;
		this.datedemande=datedemande;
		this.personnel=personnel;
		this.matriculeP=matriculeP;
	}
	
	
	public DemandeRequest(Date dateDebut, Date dateFin, int duree, String statut, String cause ,Date datedemande ,Personnel personnel,String matriculeP) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.duree = duree;
		this.statut = statut;
		this.Cause = cause;
		this.datedemande=datedemande;
		this.personnel=personnel;
		this.matriculeP=matriculeP;
		
	}




	public String getMatriculeP() {
		return matriculeP;
	}




	public void setMatriculeP(String matriculeP) {
		this.matriculeP = matriculeP;
	}




	public Date getDatedemande() {
		return datedemande;
	}




	public void setDatedemande(Date datedemande) {
		this.datedemande = datedemande;
	}




	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public String getCause() {
		return Cause;
	}


	public void setCause(String cause) {
		Cause = cause;
	}


	public Long getTypeConge() {
		return typeConge;
	}


	public void setTypeConge(Long typeConge) {
		this.typeConge = typeConge;
	}




	public Personnel getPersonnel() {
		return personnel;
	}




	public int getSoldeConge() {
		return soldeConge;
	}




	public void setSoldeConge(int soldeConge) {
		this.soldeConge = soldeConge;
	}




	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	
	
	

}
