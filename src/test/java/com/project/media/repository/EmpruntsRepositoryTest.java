package com.project.media.repository;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.media.entity.Emprunts;
import com.project.media.entity.Utilisateurs;

@DataJpaTest
public class EmpruntsRepositoryTest {
	@Autowired
	private EmpruntsRepository empruntRepository;
	
	@Autowired
	private UtilisateursRepository utilisateursRepository;
	
	@Test
	public void deleteByUtilisateurTest() {
		//Création d'un utilisateur temporaire
		Utilisateurs u = new Utilisateurs();
		u.setEmail("blaha@blue.com");
		u.setNom("Baba");
		u.setPrenom("Yage");
		utilisateursRepository.save(u);
		
		//Création d'un emprunt à suprimer
		Emprunts e = new Emprunts();
		e.setUtilisateur(u);
		empruntRepository.save(e);
		//supression de l'emprunt
		empruntRepository.deleteByUtilisateur(u);
		//Verification
		Optional<Emprunts> eSearch = empruntRepository.findByUtilisateur(u);
		assertNotEquals(e, eSearch);
	}

}
