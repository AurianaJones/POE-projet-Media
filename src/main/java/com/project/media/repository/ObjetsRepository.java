package com.project.media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.media.entity.Objets;

public interface ObjetsRepository extends JpaRepository<Objets, Long> {
	List<Objets> findAllAvailable(int quantite);
}
