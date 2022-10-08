package com.project.media.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.media.entity.Livres;

public interface LivresRepository extends JpaRepository<Livres, Long> {

}
