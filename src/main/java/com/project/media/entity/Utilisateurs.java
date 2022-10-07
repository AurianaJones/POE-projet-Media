package com.project.media.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Utilisateurs {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskSequenceGenerator")
    @SequenceGenerator(name = "taskSequenceGenerator")
	private Long Id;
	@Column
	private String email;
	@Column
	private String nom;
	@Column
	private String prenom;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
