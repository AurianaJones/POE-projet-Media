package com.project.media.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name ="Objets")
public class Items {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskSequenceGenerator")
    @SequenceGenerator(name = "taskSequenceGenerator")
	private Long id;
	@Column (name ="titre")
	private String titre;
	@Column (name = "quantite")
	private int quantite;
	@Column
	private LocalDate date_parution;
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public LocalDate getDate_parution() {
		return date_parution;
	}
	public void setDate_parution(LocalDate date_parution) {
		this.date_parution = date_parution;
	}

}
