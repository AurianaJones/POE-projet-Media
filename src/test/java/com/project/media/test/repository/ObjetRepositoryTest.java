package com.project.media.test.repository;

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
	public 
	List<Objets> findAllByQuantiteTest(){
		List<Objets> result = objetRepository.findAllByDisponible(true);
		return result;
	}

}
