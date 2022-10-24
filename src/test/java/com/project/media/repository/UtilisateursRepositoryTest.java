package com.project.media.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.media.entity.Utilisateurs;

@DataJpaTest
public class UtilisateursRepositoryTest {
	
	@Autowired
	private UtilisateursRepository utilisateursRepository;
	
	@Test
	public void findAllTest() {
		List<Utilisateurs> u = utilisateursRepository.findAll();
		assertEquals(3, u.size());
	}
	
	@Test
	public void findByEmailTest() {
		Optional<Utilisateurs> u = utilisateursRepository.findByEmail("arrow@post.tom");
		assertEquals(u.get().getNom(), "post");
	}
	
	@Test
	public void DeleteByEmailTest() {
		Utilisateurs u = new Utilisateurs();
		u.setEmail("blaha@blue.com");
		u.setNom("Baba");
		u.setPrenom("Yage");
		utilisateursRepository.save(u);
		utilisateursRepository.deleteByEmail(u.getEmail());
		Optional<Utilisateurs> uSearch = utilisateursRepository.findByEmail(u.getEmail());
		assertNotEquals(u, uSearch);
	}

}
