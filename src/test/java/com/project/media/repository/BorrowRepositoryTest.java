package com.project.media.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.media.entity.Borrow;
import com.project.media.entity.User;

@DataJpaTest
public class BorrowRepositoryTest {
	@Autowired
	private BorrowRepository empruntRepository;
	
	@Autowired
	private UserRepository utilisateursRepository;
	
	@Test
	public void findAllByUtilisateurTest() {
		User u = new User("uniko@circle.com", "Nkolo", "Scage");
		utilisateursRepository.save(u);
		Borrow e = new Borrow();
		e.setUtilisateur(u);
		empruntRepository.save(e);
		List<Borrow> listEmprunt =  empruntRepository.findAllByUtilisateur(u);
		assertEquals(1, listEmprunt.size());
	}
	
	@Test
	public void deleteByUserTest() {
		//Création d'un utilisateur temporaire
		User u = new User("blaha@blue.com", "Baba", "Yage");
		utilisateursRepository.save(u);
		//Création d'un emprunt à suprimer
		Borrow e = new Borrow();
		e.setUtilisateur(u);
		empruntRepository.save(e);
		//supression de l'emprunt
		empruntRepository.deleteByUtilisateur(u);
		//Verification
		Borrow eSearch = empruntRepository.findByUtilisateur(u);
		assertNotEquals(e, eSearch);
	}
	
	@Test
	public void updateDateRetourTest() {
		User u = new User("jajaj@oip.fr", "Ja", "Jaye");
		utilisateursRepository.save(u);
		Borrow e = new Borrow();
		e.setDateEmprunt(LocalDate.of(2020, 1, 8));
		e.setUtilisateur(u);
		empruntRepository.save(e);
		empruntRepository.updateDateRetour(LocalDate.of(2020, 1, 14), e.getId());
		Borrow eSearch = empruntRepository.findByUtilisateur(u);
		assertEquals(LocalDate.of(2020, 1, 14), eSearch.getDateRetour());
	}

}
