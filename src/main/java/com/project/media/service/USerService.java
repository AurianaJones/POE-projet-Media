package com.project.media.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.media.entity.User;
import com.project.media.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class USerService {
	
	@Autowired
	private UserRepository utilisateursRepository;
	
	public Iterable<User> getUtilisateurs(){
		return utilisateursRepository.findAll();
	}
	
	public User saveUtilisateur(User utilisateur) {
		User savedUtilisateur = utilisateursRepository.save(utilisateur);
		return savedUtilisateur;
	}

}
