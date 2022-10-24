package com.project.media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.media.entity.BorrowsItem;

@Repository
public interface BorrowsItemRepository extends JpaRepository<BorrowsItem, Long>{
	
	List<BorrowsItem> findAllByEmprunt_id(Long id);
	
	//Compter le nb d'objet d'un emprunt	
	@Query("SELECT o.emprunt, Count(o.objet) FROM BorrowsItem o GROUP BY o.emprunt")
	List<Object[]> CountObjetsEmprunterByEmprunt();

}
