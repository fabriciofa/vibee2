package com.mfqueiroga.vibee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfqueiroga.vibee.entities.Beehive;
import com.mfqueiroga.vibee.repositories.BeehiveRepository;

@Service
public class BeehiveService {

	@Autowired
	private BeehiveRepository repository;
	
	public List<Beehive> findAll(){
		return repository.findAll();
	}
	
	public Beehive findById(Long id) {
		Optional<Beehive> obj = repository.findById(id);
		return obj.get();
	}
}
