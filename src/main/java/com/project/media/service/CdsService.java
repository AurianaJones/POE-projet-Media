package com.project.media.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.media.entity.Cds;
import com.project.media.repository.CdsRepository;

import lombok.Data;

@Data
@Service
public class CdsService {
	
	@Autowired
	private CdsRepository cdRepository;
	
	public Optional<Cds> getCd(final Long id){
		return cdRepository.findById(id);
	}
	
	public Iterable<Cds> getCds(){
		return cdRepository.findAll();
	}
	
	public void deleteCds(final Long id) {
		cdRepository.deleteById(id);
	}
	
	public Cds saveCd(Cds cd) {
		Cds savedCds = cdRepository.save(cd);
		return savedCds;
	}

}
