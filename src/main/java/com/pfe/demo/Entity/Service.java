package com.pfe.demo.Entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Service")

	
	public class Service implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	      private Long idService ;
		
		@OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "idChef")
	    private Personnel personnel;
	      private String nomService ;
	     
	      
//	     @OneToMany(mappedBy="role",fetch = FetchType.LAZY)
//	  	private Collection<Personnel> personnels;

	     public Service() {
			// TODO Auto-generated constructor stub
		}

		public Long getIdService() {
			return idService;
		}

		public void setIdService(Long idService) {
			this.idService = idService;
		}

		

		public Personnel getPersonnel() {
			return personnel;
		}

		public void setPersonnel(Personnel personnel) {
			this.personnel = personnel;
		}

		public String getNomService() {
			return nomService;
		}

		public void setNomService(String nomService) {
			this.nomService = nomService;
		}


	     
	     
}