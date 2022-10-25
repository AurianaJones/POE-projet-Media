package com.project.media.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.media.entity.Borrow;
import com.project.media.entity.BorrowsItem;
import com.project.media.entity.Items;
import com.project.media.entity.User;
import com.project.media.repository.ItemsRepository;
import com.project.media.repository.UserRepository;
import com.project.media.service.exception.EmptyBorrowException;
import com.project.media.service.exception.MaxBorrowException;

@SpringBootTest
public class BorrowServiceTest {
	
	@Autowired
	private BorrowService borrowService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItemsRepository itemRepository;
	
	@Test
	void borrowItems() throws MaxBorrowException, EmptyBorrowException {
		User u = userRepository.findByEmail("borrow@book.lom");
		List<Items> newItemsToBorrow = new ArrayList<>();
		Items item1 = itemRepository.findById((long)1);
		Items item2 = itemRepository.findById((long)2);
		newItemsToBorrow.add(item1);
		newItemsToBorrow.add(item2);
		List<BorrowsItem> borrowe = borrowService.borrowItems(u, newItemsToBorrow);
		assertEquals(2, borrowe.size());
	}
}
