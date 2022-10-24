package com.project.media.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
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
		Utilisateurs u = new Utilisateurs("blaha@blue.com", "Baba", "Yage");
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
	
	@Test
	public void updateDateRetourTest() {
		Utilisateurs u = new Utilisateurs("jajaj@oip.fr", "Ja", "Jaye");
		utilisateursRepository.save(u);
		Emprunts e = new Emprunts();
		e.setDateEmprunt(LocalDate.of(2020, 1, 8));
		e.setUtilisateur(u);
		empruntRepository.save(e);
		empruntRepository.updateDateRetour(LocalDate.of(2020, 1, 14), e.getId());
		Optional<Emprunts> eSearch = empruntRepository.findByUtilisateur(u);
		assertEquals(LocalDate.of(2020, 1, 14), eSearch.get().getDateRetour());
	}

}
