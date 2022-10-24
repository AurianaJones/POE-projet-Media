package com.project.media.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cds")
public class Cds extends Objets{

	@Column (name = "artiste")
	private String artiste;
	
	@Column (name = "duree")
	private double duree;
	
	@Column (name = "nombre_titres")
	private int nb_titres;

	public String getArtiste() {
		return artiste;
	}

	public void setArtiste(String artiste) {
		this.artiste = artiste;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	public int getNb_titres() {
		return nb_titres;
	}

	public void setNb_titres(int nb_titres) {
		this.nb_titres = nb_titres;
	}
	
	
}
