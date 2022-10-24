package com.project.media.repository;


import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.media.entity.Emprunts;
import com.project.media.entity.Utilisateurs;

@Repository
public interface EmpruntsRepository extends JpaRepository<Emprunts, Long>{
	
	
	long deleteByUtilisateur(Utilisateurs u);

	Optional<Emprunts> findByUtilisateur(Utilisateurs u);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Emprunts e SET e.dateRetour = ?1 WHERE e.id = ?2")
	void updateDateRetour(@Param(value = "dateRetour") LocalDate dateRetour, @Param(value = "id") long id);
}
