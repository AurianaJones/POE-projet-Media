package com.project.media.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.media.entity.Livres;
import com.project.media.repository.LivresRepository;

import lombok.Data;

@Data
@Service
public class LivresService {
	
	@Autowired
	private LivresRepository livresRepository;
	
	public Optional<Livres> getLivre(final Long id){
		return livresRepository.findById(id);
	}
	
	public Iterable<Livres> getLivres(){
		return livresRepository.findAll();
	}
	
	public void deleteLivre(final Long id) {
		livresRepository.deleteById(id);
	}
	
	public Livres saveLivre(Livres livre) {
		Livres savedLivre = livresRepository.save(livre);
		return savedLivre;
	}

}
