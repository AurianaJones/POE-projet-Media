package com.project.media.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.media.entity.Utilisateurs;

@Repository
public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Long>{

	List<Utilisateurs> findAll();
	
	Optional<Utilisateurs> findByEmail(String email);
	
	void deleteByEmail(String email);

}
