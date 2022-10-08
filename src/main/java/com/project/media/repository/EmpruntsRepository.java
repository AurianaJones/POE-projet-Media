package com.project.media.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.media.entity.Emprunts;

public interface EmpruntsRepository extends JpaRepository<Emprunts, Long> {

}
