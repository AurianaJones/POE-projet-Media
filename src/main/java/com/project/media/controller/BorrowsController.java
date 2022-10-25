package com.project.media.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.media.entity.Borrow;
import com.project.media.entity.BorrowsItem;
import com.project.media.entity.Items;
import com.project.media.entity.User;
import com.project.media.repository.BorrowRepository;
import com.project.media.repository.UserRepository;
import com.project.media.service.BorrowService;
import com.project.media.service.exception.EmptyBorrowException;
import com.project.media.service.exception.MaxBorrowException;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/borrows")
public class BorrowsController {
	
	@Autowired
	private BorrowRepository borrowRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BorrowService borrowService;
	
	@GetMapping("/{email}")
	public ResponseEntity<List<Borrow>> findAllBorrow(@PathVariable String email){
		User user = userRepository.findByEmail(email);
		return ResponseEntity.ok(borrowRepository.findAllByUtilisateur(user));
	}
	
	@PostMapping("/{email}/borrow_new/")
	public ResponseEntity<List<BorrowsItem>> newBorrow(@PathVariable String email, @RequestBody List<Items> items) throws MaxBorrowException, EmptyBorrowException {
		User user = userRepository.findByEmail(email);
		return ResponseEntity.status(HttpStatus.CREATED).body(borrowService.borrowItems(user, items));
	}
	
}
