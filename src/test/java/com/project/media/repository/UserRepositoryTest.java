package com.project.media.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.media.entity.User;

@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository utilisateursRepository;
	
	@Test
	public void findAllTest() {
		List<User> u = utilisateursRepository.findAll();
		assertEquals(3, u.size());
	}
	
	@Test
	public void findByEmailTest() {
		User u = utilisateursRepository.findByEmail("arrow@post.tom");
		assertEquals(u.getNom(), "post");
	}
	
	@Test
	public void DeleteByEmailTest() {
		User u = new User();
		u.setEmail("blaha@blue.com");
		u.setNom("Baba");
		u.setPrenom("Yage");
		utilisateursRepository.save(u);
		utilisateursRepository.deleteByEmail(u.getEmail());
		User uSearch = utilisateursRepository.findByEmail(u.getEmail());
		assertNotEquals(u, uSearch);
	}

}
