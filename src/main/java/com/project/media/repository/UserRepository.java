package com.project.media.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.media.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findAll();
	
	Optional<User> findByEmail(String email);
	
	long deleteByEmail(String email);

}
