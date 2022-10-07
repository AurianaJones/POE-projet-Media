package com.project.media.entity;

import javax.persistence.Column;
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
public class ObjetsEmprunter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Emprunts emprunt;
	
	@ManyToOne
	private Objets objet;
	
	@Column (name = "quantite_emprunter")
	private int qte;
}
