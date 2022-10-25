package com.project.media.service;

import java.time.LocalDate;
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

@Service
@Transactional
public class BorrowService {

	@Autowired
	private BorrowRepository borrowRepository;
	
	@Autowired
	private BorrowsItemRepository borrowItemsRepository;

	public Borrow borrowItems(User u, List<Items> listItems) {
		// Récupération des emprunts déjà effectuer
		List<Borrow> alreadyBorrow = borrowRepository.findAllByUtilisateur(u);
		// Verification que l'utilisateur a moins de 3 emprunts
		if (alreadyBorrow.size() >= 3) {
			return null;
		}
		List<Borrow> actualBorrows = null;
		actualBorrows.addAll(alreadyBorrow);
		List<Borrow> newBorrow = null;
		
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
			return null;
		}
		if (actualBorrows.size() == 0) {
			return null;
		} else { //Sauvegarder les emprunts dans la base
			int i = 0;
			for (Borrow borrow : newBorrow) {
				borrowRepository.save(borrow);
				BorrowsItem bi = new BorrowsItem();
				bi.setEmprunt(borrow);
				bi.setObjet(listItems.get(i));
				borrowItemsRepository.save(bi);
				i++;
			}
			return null;
		}
	}
}
