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
}
