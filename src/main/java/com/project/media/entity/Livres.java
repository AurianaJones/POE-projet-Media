package com.project.media.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Livres extends Items{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskSequenceGenerator")
    @SequenceGenerator(name = "taskSequenceGenerator")
	private Long id;
	@Column (name = "auteur")
	private String auteur;
	@Column (name = "numero_ISBN")
	private String isbnNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getIsbnNum() {
		return isbnNum;
	}

	public void setIsbnNum(String isbnNum) {
		this.isbnNum = isbnNum;
	}
}
