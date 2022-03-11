package com.katwdojo.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.katwdojo.dojosandninjas.models.Ninja;
import com.katwdojo.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	private final NinjaRepository ninjaRepo;
	
	public NinjaService (NinjaRepository ninjaRepo) {
		this.ninjaRepo=ninjaRepo;
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Ninja findNinja(Long id) {
		return ninjaRepo.findById(id).orElse(null);
	}
}
