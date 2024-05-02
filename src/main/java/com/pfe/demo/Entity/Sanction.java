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

@Entity
@Table(name="sanction")
public class Sanction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSanction;
	private String nomSnaction;
	private Date dateSanction;
	
	@ManyToOne
	@JoinColumn(name="idEmploye")
	private Personnel personnel;
	
	public Sanction() {
		// TODO Auto-generated constructor stub
	}

	public Sanction(String nomSnaction, Date dateSanction) {
		super();
		this.nomSnaction = nomSnaction;
		this.dateSanction = dateSanction;
	}

	public Long getIdSanction() {
		return idSanction;
	}

	public void setIdSanction(Long idSanction) {
		this.idSanction = idSanction;
	}

	public String getNomSnaction() {
		return nomSnaction;
	}

	public void setNomSnaction(String nomSnaction) {
		this.nomSnaction = nomSnaction;
	}

	public Date getDateSanction() {
		return dateSanction;
	}

	public void setDateSanction(Date dateSanction) {
		this.dateSanction = dateSanction;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}



	
	
}
