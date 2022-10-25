package com.project.media.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.media.entity.Borrow;
import com.project.media.entity.User;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long>{

	Borrow findByUtilisateur(User u);
	
	Borrow findById(long id);
	
	List<Borrow>findAllByUtilisateur(User u);
	
	long deleteByUtilisateur(User u);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Borrow e SET e.dateRetour = ?1 WHERE e.id = ?2")
	void updateDateRetour(@Param(value = "dateRetour") LocalDate dateRetour, @Param(value = "id") long id);
}
