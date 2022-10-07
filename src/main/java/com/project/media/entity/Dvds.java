package com.project.media.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.project.media.util.Dvd_Type;

@Entity
@Table(name = "dvds")
public class Dvds extends Items {
	
	@Column (name = "réalisateur")
	private String realisateur;
	
	@Column (name = "durée")
	private double duree;
	
	@Enumerated(EnumType.STRING)
	private Dvd_Type type;

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	public Dvd_Type getType() {
		return type;
	}

	public void setType(Dvd_Type type) {
		this.type = type;
	}

	
	

}
