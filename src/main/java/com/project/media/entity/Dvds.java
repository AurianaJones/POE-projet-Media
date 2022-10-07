package com.project.media.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.project.media.util.Dvd_Type;

@Entity
@Table(name = "dvds")
public class Dvds extends Items {
	
	@Column (name = "realisateur")
	private String realisateur;
	
	@Column (name = "duree")
	private double duree;
	
	@Column (name = "dvd_type")
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
