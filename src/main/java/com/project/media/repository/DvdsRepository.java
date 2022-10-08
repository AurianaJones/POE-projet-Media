package com.project.media.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.media.entity.Dvds;

public interface DvdsRepository extends JpaRepository<Dvds, Long> {

}
