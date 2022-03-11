package com.katwdojo.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.katwdojo.dojosandninjas.models.Dojo;
import com.katwdojo.dojosandninjas.repositories.DojoRepository;


@Service
public class DojoService {
	
	private final DojoRepository dojoRepo;
	
	public DojoService (DojoRepository dojoRepo) {
		this.dojoRepo=dojoRepo;
	}
		
	public List<Dojo> getAllDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Dojo findDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
	

}
