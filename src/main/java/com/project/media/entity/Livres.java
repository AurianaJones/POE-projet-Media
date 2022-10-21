package com.project.media.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "livres")
public class Livres extends Objets{
	
	@Column (name = "auteur")
	private String auteur;
	
	@Column (name = "numero_ISBN")
	private String isbnNum;

}
