package com.project.media;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.media.entity.Objets;
import com.project.media.repository.ObjetsRepository;

@DataJpaTest
public class ObjetRepositoryTest {
	
	@Autowired
	private ObjetsRepository objetRepository;
	
	@Test
	public void findAllObjetDisponibleTest(){
		List<Objets> objets = objetRepository.findAllObjetDisponible();
		assertEquals(8, objets.size());
	}
	
	@Test
	public void findAllOrderByDateTest() {
		List<Objets> objets = objetRepository.findAllOrderByDate();
		assertEquals("livre3",objets.get(0).getTitre());
	}
	


}
