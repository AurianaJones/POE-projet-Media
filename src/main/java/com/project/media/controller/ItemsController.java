package com.project.media.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.media.entity.Book;
import com.project.media.entity.Cd;
import com.project.media.entity.Dvd;
import com.project.media.entity.Items;
import com.project.media.repository.ItemsRepository;

@RestController
@RequestMapping("/api/items")
public class ItemsController {
	
	@Autowired
	ItemsRepository itemsRepository;
	
	//Liste tout les Items
	@GetMapping
	public ResponseEntity<List<Items>> findAllItems(){
		return ResponseEntity.ok(itemsRepository.findAll());
	}
	
	//Liste des Objets Disponible
	@GetMapping("/availble")
	public ResponseEntity<List<Items>> findAllAvailbleItem(){
		return ResponseEntity.ok(itemsRepository.findAllAvailbleItem());
	}
	
	//Liste des Objets par ordre de parution
	@GetMapping("/in_order")
	public ResponseEntity<List<Items>> findAllInOrder(){
		return ResponseEntity.ok(itemsRepository.findAllOrderByDate());
	}
	
	//Liste tout les Dvd
	@GetMapping("/dvd")
	public ResponseEntity<List<Dvd>> findAllDvd(){
		return ResponseEntity.ok(itemsRepository.findAllDvd());
	}
	
	//Tout les Cd
	@GetMapping("/cd")
	public ResponseEntity<List<Cd>> findAllCd(){
		return ResponseEntity.ok(itemsRepository.findAllCd());
	}
	
	//Tout les livres
	@GetMapping("/book")
	public ResponseEntity<List<Book>> findAllBook(){
		return ResponseEntity.ok(itemsRepository.findAllBook());
	}
	
	
	
}
