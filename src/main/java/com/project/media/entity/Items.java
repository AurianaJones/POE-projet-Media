package com.project.media.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Items {
	
	private String titre;
	private int quantite;
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
