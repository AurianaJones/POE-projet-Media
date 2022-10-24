package com.project.media.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.media.entity.ObjetsEmprunter;

@DataJpaTest
public class ObjetEmprunterRepositoryTest {
	
	@Autowired
	private ObjetsEmprunterRepository objetsEmprunterRepository;
	
	@Test
	public void findAllByEmprunt_id() {
		List<ObjetsEmprunter> ob = objetsEmprunterRepository.findAllByEmprunt_id((long) 2);
		assertEquals(3 , ob.size());		
	}
	
	@Test
	public void CountObjetsEmprunterByEmpruntTest() {
		List<Object[]> countOb = objetsEmprunterRepository.CountObjetsEmprunterByEmprunt();
		assertEquals((long)1, countOb.get(0)[1]);
	}

}
