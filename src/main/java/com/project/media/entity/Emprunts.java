package com.project.media.entity;

import java.time.LocalDate;

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
@Table(name = "emprunts")
public class Emprunts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date_emprunt")
	private LocalDate dateEmprunt;

	@Column(name = "date_retour")
	private LocalDate dateRetour;

	@ManyToOne
	private Utilisateurs utilisateur;
}
