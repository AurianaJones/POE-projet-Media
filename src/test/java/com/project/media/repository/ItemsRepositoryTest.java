package com.project.media.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.media.entity.Cd;
//import com.project.media.entity.Dvds;
//import com.project.media.entity.Livres;
import com.project.media.entity.Items;

@DataJpaTest
public class ItemsRepositoryTest {

	@Autowired
	private ItemsRepository itemRepository;

	@Test
	public void findAllObjetDisponibleTest() {
		List<Items> objets = itemRepository.findAllAvailbleItem();
		assertEquals(8, objets.size());
	}

	@Test
	public void findAllOrderByDateTest() {
		List<Items> objets = itemRepository.findAllOrderByDate();
		assertEquals("livre3", objets.get(0).getTitre());
	}

	@Test
	public void findAllCdsTest() {
		List<Cd> cds = itemRepository.findAllCd();
		assertEquals(3, cds.size());
	}

	@Test
	public void updateQuantiteTest() {
		Items i = new Items();
		i.setTitre("Bloup");
		i.setDate(LocalDate.of(2020, 12, 01));
		i.setQuantite(2);
		itemRepository.save(i);
		int n = i.getQuantite() - 1;
		itemRepository.updateQuantite(n, i.getId());
		Optional<Items> search = itemRepository.findById(i.getId());
		assertEquals(1, search.get().getQuantite());
	}

	/*
	 * @Test public void findAllDvdsTest() { List<Dvds> dvds =
	 * objetRepository.findAllDvds(); assertEquals(3, dvds.size()); }
	 * 
	 * @Test public void findAllLivresTest() { List<Livres> livres =
	 * objetRepository.findAllLivres(); assertEquals(3, livres.size()); }
	 */

}
