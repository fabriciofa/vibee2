package com.mfqueiroga.vibee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfqueiroga.vibee.entities.Beehive;
import com.mfqueiroga.vibee.entities.Localization;
import com.mfqueiroga.vibee.repositories.BeehiveRepository;
import com.mfqueiroga.vibee.repositories.LocalizationRepository;

@Service
public class BeehiveService {

	@Autowired
	private BeehiveRepository repository;

	@Autowired
	private LocalizationRepository localizationRepository;

	public List<Beehive> findAll() {
		return repository.findAll();
	}

	public Beehive findById(Long id) {
		Optional<Beehive> obj = repository.findById(id);
		return obj.get();
	}

	public Beehive insert(Beehive obj) {

		Localization receivedLocalization = obj.getLocal();
		localizationRepository.save(receivedLocalization);
		obj.setLocal(receivedLocalization);

		return repository.save(obj);
	}
}
