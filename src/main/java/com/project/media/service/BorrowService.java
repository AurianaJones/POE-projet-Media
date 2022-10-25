package com.project.media.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.media.entity.Borrow;
import com.project.media.entity.BorrowsItem;
import com.project.media.entity.Items;
import com.project.media.entity.User;
import com.project.media.repository.BorrowRepository;
import com.project.media.repository.BorrowsItemRepository;
import com.project.media.service.exception.EmptyBorrowException;
import com.project.media.service.exception.MaxBorrowException;

@Service
@Transactional
public class BorrowService {

	@Autowired
	private BorrowRepository borrowRepository;
	
	@Autowired
	private BorrowsItemRepository borrowItemsRepository;

	public List<BorrowsItem> borrowItems(User u, List<Items> listItems) throws MaxBorrowException, EmptyBorrowException {
		// Récupération des emprunts déjà effectuer
		List<Borrow> alreadyBorrow = borrowRepository.findAllByUtilisateur(u);
		// Verification que l'utilisateur a moins de 3 emprunts
		if (alreadyBorrow.size() >= 3) {
			throw new MaxBorrowException("Cette utilisateur à déjà :" + alreadyBorrow.size());
		}
		List<Borrow> actualBorrows = new ArrayList<>();
		actualBorrows.addAll(alreadyBorrow);
		List<Borrow> newBorrow = new ArrayList<>();
		
		// Création des nouveaux emprunts qu'on ajoute au emprunt actif
		for (int i = 0; i < listItems.size(); i++) {
			Borrow b = new Borrow();
			b.setDateEmprunt(LocalDate.now());
			b.setUtilisateur(u);
			actualBorrows.add(b);
			newBorrow.add(b);
		}
		// Verification que l'emprunt est autorisé
		if (actualBorrows.size() > 3) {
			throw new MaxBorrowException("Emprunt actuel :" + actualBorrows.size());
		}
		if (actualBorrows.size() == 0) {
			throw new EmptyBorrowException();
		} else { //Sauvegarder les emprunts dans la base
			int i = 0;
			List<BorrowsItem> borrowedItems = new ArrayList<>();
			for (Borrow borrow : newBorrow) {
				borrowRepository.save(borrow);
				BorrowsItem bi = new BorrowsItem();
				bi.setEmprunt(borrow);
				bi.setObjet(listItems.get(i));
				borrowItemsRepository.save(bi);
				borrowedItems.add(bi);
				i++;
			}
			return borrowedItems;
		}
	}
}