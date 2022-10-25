package com.project.media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.media.entity.Cd;
import com.project.media.entity.Dvd;
import com.project.media.entity.Book;
import com.project.media.entity.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {
	
	Items findByTitre(String titre);
	
	Items findById(long i);

	@Query ("SELECT o FROM Items o WHERE o.quantite !=0")
	List<Items> findAllAvailbleItem();
	
	@Query("SELECT o FROM Items o ORDER BY date_parution DESC")
	List<Items> findAllOrderByDate ();
	
	@Query("SELECT o FROM Items o JOIN Cd c ON o.id = c.id")
	List<Cd> findAllCd();
	
	@Query("SELECT o FROM Items o JOIN Dvd d ON o.id = d.id")
	List<Dvd> findAllDvd();
	
	@Query("SELECT o FROM Items o JOIN Book l ON o.id = l.id")
	List<Book> findAllBook();
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Items o SET o.quantite = ?1 WHERE o.id = ?2")
	void updateQuantite(@Param(value = "quantite") int quantite, @Param(value = "id") long id);

	
}
