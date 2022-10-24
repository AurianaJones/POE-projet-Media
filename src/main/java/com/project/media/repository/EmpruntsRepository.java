package com.project.media.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.media.entity.Emprunts;
import com.project.media.entity.Utilisateurs;

@Repository
public interface EmpruntsRepository extends JpaRepository<Emprunts, Long>{
	
	
	long deleteByUtilisateur(Utilisateurs u);

	Optional<Emprunts> findByUtilisateur(Utilisateurs u);

}
