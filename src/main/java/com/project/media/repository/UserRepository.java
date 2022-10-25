package com.project.media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.media.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findAll();
	
	User findByEmail(String email);
	
	long deleteByEmail(String email);

}
