package com.project.media.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.media.entity.Utilisateurs;
import com.project.media.repository.UtilisateursRepository;

import lombok.Data;

@Data
@Service
public class UtilisateursService {
	
	@Autowired
	private UtilisateursRepository utilisateursRepository;
	
	public Iterable<Utilisateurs> getUtilisateurs(){
		return utilisateursRepository.findAll();
	}
	
	public Utilisateurs saveUtilisateur(Utilisateurs utilisateur) {
		Utilisateurs savedUtilisateur = utilisateursRepository.save(utilisateur);
		return savedUtilisateur;
	}

}
