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
import com.project.media.repository.ItemsRepository;
import com.project.media.service.exception.EmptyBorrowException;
import com.project.media.service.exception.EmptyItemsException;
import com.project.media.service.exception.MaxBorrowException;
import com.project.media.service.exception.NoMatchException;
import com.project.media.service.exception.OutOfStockException;

@Service
@Transactional
public class BorrowService {

	@Autowired
	private BorrowRepository borrowRepository;

	@Autowired
	private BorrowsItemRepository borrowItemsRepository;

	@Autowired
	private ItemsRepository itemsRepository;

	public List<BorrowsItem> borrowItems(User u, List<Items> listItems)
			throws MaxBorrowException, EmptyBorrowException, OutOfStockException {
		// Récupération des emprunts déjà effectuer
		List<Borrow> alreadyBorrow = borrowRepository.findAllByUtilisateur(u);

		// Verification que l'utilisateur a moins de 3 emprunts
		List<Borrow> actualBorrows = new ArrayList<>();
		for (Borrow b : alreadyBorrow) {
			if (b.getDateRetour() == null) {
				actualBorrows.add(b);
			}
		}
		if (actualBorrows.size() >= 3) {
			throw new MaxBorrowException("Cette utilisateur à déjà :" + alreadyBorrow.size());
		}
		//Verifier que les objets sont en stock
		for (Items item : listItems) {
			if(item.getQuantite() <= 0){
				throw new OutOfStockException(item.getTitre());
			}
		}
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
		} else { // Sauvegarder les emprunts dans la base
			int i = 0;
			List<BorrowsItem> borrowedItems = new ArrayList<>();
			for (Borrow borrow : newBorrow) {
				borrowRepository.save(borrow);
				BorrowsItem bitem = new BorrowsItem();
				bitem.setEmprunt(borrow);
				Items o = listItems.get(i);
				bitem.setObjet(o);
				Items objDB = itemsRepository.findByTitre(o.getTitre());
				itemsRepository.updateQuantite(objDB.getQuantite() - 1, objDB.getId());
				borrowItemsRepository.save(bitem);
				borrowedItems.add(bitem);
				i++;
			}
			return borrowedItems;
		}
	}

	public void returnBorrowItems(User u, long borrow_id) throws EmptyItemsException, NoMatchException {
		// On vérifie que l'emprunt et l'utilisateur corresponde
		List<Borrow> userBorrow = borrowRepository.findAllByUtilisateur(u);
		Borrow borrowToReturn = borrowRepository.findById(borrow_id);
		if (!userBorrow.contains(borrowToReturn)) {
			throw new NoMatchException("" + borrowToReturn);
		} else {
			// On met a jour la date de retour de l'emprunt pour le conclure
			borrowRepository.updateDateRetour(LocalDate.now(), borrow_id);
			// On récupére les objets emprunter pour remettre l'emprunt à sa place
			List<BorrowsItem> ib = borrowItemsRepository.findAllByEmprunt_id(borrow_id);
			for (BorrowsItem itemBorrowed : ib) {
				Items i = itemsRepository.findById(itemBorrowed.getObjet().getId()).get();
				if (i == null) {
					throw new EmptyItemsException();
				} else {
					int i_quatite = i.getQuantite() + 1;
					itemsRepository.updateQuantite(i_quatite, i.getId());
				}
			}
		}

	}
}