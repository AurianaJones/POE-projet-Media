package com.project.media.entity;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "objets_emprunter")
public class BorrowsItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Borrow emprunt;
	
	@ManyToOne
	private Items objet;
	
	/*
	 * @Column (name = "quantite_emprunter") private int qte;
	 */

	public Borrow getEmprunt() {
		return emprunt;
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
