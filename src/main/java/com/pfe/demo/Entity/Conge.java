package com.pfe.demo.Entity;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="conge")

public class Conge implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  idConge ; 
	private Date dateDebut  ;
	private  Date dateFin ;
	private int duree;
	private String statut ;
	private String Cause;
	private int soldeConge;
	private Date datedemande;
	private String matriculeP;
	private String reponse ;
	private String gererPar;
	
	@ManyToOne
	@JoinColumn(name="idEmploye")
	private Personnel personnel;
	
	@ManyToOne
	@JoinColumn(name="idType")
	private TypeConge typeConge;
	
	public Conge() {
		// TODO Auto-generated constructor stub
	}
	
	


	
	



	public Conge(Long idConge, Date dateDebut, Date dateFin, int duree, String statut, String cause, int soldeConge,
			Date datedemande, String matriculeP, String reponse, String gererPar, Personnel personnel,
			TypeConge typeConge) {
		super();
		this.idConge = idConge;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.duree = duree;
		this.statut = statut;
		Cause = cause;
		this.soldeConge = soldeConge;
		this.datedemande = datedemande;
		this.matriculeP = matriculeP;
		this.reponse = reponse;
		this.gererPar = gererPar;
		this.personnel = personnel;
		this.typeConge = typeConge;
	}









	public Conge( Date dateDebut, Date dateFin, int duree, String statut, String cause , int soldeConge ,Date datedemande ,Personnel personnel,String matriculeP){
		super();
		
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.duree = duree;
		this.statut = statut;
		this.Cause = cause;
		this.soldeConge = soldeConge;
		this.datedemande=datedemande;
		this.personnel= personnel;
		this.matriculeP=matriculeP;
		
		
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String getMatriculeP() {
		return matriculeP;
	}



	public void setMatriculeP(String matriculeP) {
		this.matriculeP = matriculeP;
	}



	public int getSoldeConge() {
		return soldeConge;
	}



	public void setSoldeConge(int soldeConge) {
		this.soldeConge = soldeConge;
	}



	public Date getDatedemande() {
		return datedemande;
	}



	public void setDatedemande(Date datedemande) {
		this.datedemande = datedemande;
	}



	public Long getIdConge() {
		return idConge;
	}

	public void setIdConge(Long idConge) {
		this.idConge = idConge;
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









	public Personnel getPersonnel() {
		return personnel;
	}



	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}



	public TypeConge getTypeConge() {
		return typeConge;
	}



	public void setTypeConge(TypeConge typeConge) {
		this.typeConge = typeConge;
	}



	public int getSoldeCongé() {
		return soldeConge;
	}



	public void setSoldeCongé(int soldeCongé) {
		this.soldeConge = soldeCongé;
	}



	public String getCause() {
		return Cause;
	}



	public void setCause(String cause) {
		Cause = cause;
	}









	

	

	
	
	
}