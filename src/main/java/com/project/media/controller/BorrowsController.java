package com.project.media.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.media.entity.Borrow;
import com.project.media.entity.User;
import com.project.media.repository.BorrowRepository;
import com.project.media.repository.UserRepository;

@RestController
@RequestMapping("/api/borrows")
public class BorrowsController {
	
	@Autowired
	private BorrowRepository borrowRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{email}")
	public ResponseEntity<List<Borrow>> findAllBorrow(@PathVariable String email){
		User user = userRepository.findByEmail(email);
		return ResponseEntity.ok(borrowRepository.findAllByUtilisateur(user));
	}
	
}
