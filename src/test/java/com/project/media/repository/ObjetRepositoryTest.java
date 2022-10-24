package com.project.media.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.media.entity.Cds;
//import com.project.media.entity.Dvds;
//import com.project.media.entity.Livres;
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
	
	@Test
	public void findAllCdsTest() {
		List<Cds> cds = objetRepository.findAllCds();
		assertEquals(3, cds.size());
	}
	/*
	 * @Test public void findAllDvdsTest() { List<Dvds> dvds =
	 * objetRepository.findAllDvds(); assertEquals(3, dvds.size()); }
	 * 
	 * @Test public void findAllLivresTest() { List<Livres> livres =
	 * objetRepository.findAllLivres(); assertEquals(3, livres.size()); }
	 */
	
}
