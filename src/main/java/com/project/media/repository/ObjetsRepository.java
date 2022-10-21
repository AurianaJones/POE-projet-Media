package com.project.media.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.media.entity.Cds;
import com.project.media.entity.Dvds;
import com.project.media.entity.Livres;
import com.project.media.entity.Objets;

public interface ObjetsRepository extends JpaRepository<Objets, Long> {
	
	List<Objets> findAllByDisponible(Boolean bool);
	List<Objets> findAllByDate (LocalDate date_parution);
	
	//Trouver les objet par type 
	List<Cds> findAllCdById(int id);
	List<Dvds> findAllDvdById(int id);
	List<Livres> findAllLivreById(int id);
}
