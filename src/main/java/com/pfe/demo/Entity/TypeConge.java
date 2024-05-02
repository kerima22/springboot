package com.pfe.demo.Entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class TypeConge implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	  @Column(length = 20)
	  private EtypeConge nomTypeConge;
	
//	@OneToMany(mappedBy ="typeConge" ,fetch= FetchType.LAZY)
//	private Collection<Conge> Conges;
	
	
	
	public TypeConge() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idType) {
		this.id = idType;
	}



	public EtypeConge getNomTypeconConge() {
		return nomTypeConge;
	}

	public void setNomTypeconConge(EtypeConge nomTypeconConge) {
		this.nomTypeConge = nomTypeconConge;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}