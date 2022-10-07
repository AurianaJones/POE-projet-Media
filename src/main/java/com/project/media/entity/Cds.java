package com.project.media.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cds")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Cds extends Items{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskSequenceGenerator")
    @SequenceGenerator(name = "taskSequenceGenerator")
	private Long id;
	
	@Column (name = "artiste")
	private String artiste;
	
	@Column (name = "durée")
	private double duree;
	
	@Column (name = "nombre_titres")
	private int nb_titres;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
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
