package com.project.media.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.media.entity.Dvds;
import com.project.media.repository.DvdsRepository;

import lombok.Data;

@Data
@Service
public class DvdsService {
	@Autowired
	private DvdsRepository dvdRepository;
	
	public Optional<Dvds> getDvd(final Long id){
		return dvdRepository.findById(id);
	}
	
	public Iterable<Dvds> getDvds(){
		return dvdRepository.findAll();
	}
	
	public void deleteDvd(final Long id) {
		dvdRepository.deleteById(id);
	}
	
	public Dvds saveDvd(Dvds dvd) {
		Dvds savedDvd = dvdRepository.save(dvd);
		return savedDvd;
	}

}
