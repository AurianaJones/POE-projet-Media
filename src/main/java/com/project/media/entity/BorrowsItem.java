package com.project.media.entity;

//import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "objets_emprunter")
public class BorrowsItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne //(cascade = CascadeType.ALL)
	@JsonIgnore //si pb de boucle infini
	private Borrow emprunt;
	
	@ManyToOne //(cascade = CascadeType.ALL)
	@JsonIgnore //si pb de boucle infini
	private Items objet;
	
	/*
	 * @Column (name = "quantite_emprunter") private int qte;
	 */

	
	
	public Borrow getEmprunt() {
		return emprunt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmprunt(Borrow emprunt) {
		this.emprunt = emprunt;
	}

	public Items getObjet() {
		return objet;
	}

	public void setObjet(Items objet) {
		this.objet = objet;
	}

	/*
	 * public int getQte() { return qte; }
	 * 
	 * public void setQte(int qte) { this.qte = qte; }
	 */
	
}
