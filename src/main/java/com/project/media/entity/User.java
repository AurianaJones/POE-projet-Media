package com.project.media.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "utilisateurs")
public class User {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String email;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;

	//@Column
	//private String password;

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

	// public String getPassword(){
	// 	return password;
	// }

	// public void setPassword(String pass){
	// 	this.password = pass;
	// }

	public User() {
		super();
	}

	public User(String email, String nom, String prenom) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
	}
	
}
