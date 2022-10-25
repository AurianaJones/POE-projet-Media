package com.project.media.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.media.entity.Borrow;
import com.project.media.entity.Items;
import com.project.media.entity.User;
import com.project.media.repository.BorrowRepository;
import com.project.media.repository.ItemsRepository;

@Service
@Transactional
public class BorrowService {

	@Autowired
	private BorrowRepository borrowRepository;
	@Autowired
	private ItemsRepository itemsRepository;

	public Borrow borrowItems(User u, List<Items> listItems) {
		List<Borrow> alreadyBorrow = borrowRepository.findAllByUtilisateur(u);
				
		if (listItems.size() > 3) {

			return null;
		}
		if(listItems.size() == 0) {

			return null;
		}else {

			return null;
		}
	}

}
