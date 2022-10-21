package com.project.media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.media.entity.Cds;
import com.project.media.entity.Dvds;
import com.project.media.entity.Livres;
import com.project.media.entity.Objets;

public interface ObjetsRepository extends JpaRepository<Objets, Long> {
	
	//List<Objets> findAllByDisponible(Boolean bool);

	@Query ("SELECT o FROM Objets o WHERE o.quantite !=0")
	List<Objets> findAllObjetDisponible();
	
	@Query("SELECT o FROM Objets o ORDER BY date_parution DESC")
	List<Objets> findAllOrderByDate ();
	
	@Query("SELECT o FROM Objets o JOIN Cds c ON o.id = c.id")
	List<Cds> findAllCds();
	@Query("SELECT o FROM Objets o JOIN Dvds d ON o.id = d.id")
	List<Dvds> findAllDvds();
	@Query("SELECT o FROM Objets o JOIN Livres l ON o.id = l.id")
	List<Livres> findAllLivres();
}
