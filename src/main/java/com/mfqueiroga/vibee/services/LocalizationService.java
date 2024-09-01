package com.mfqueiroga.vibee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfqueiroga.vibee.entities.Localization;
import com.mfqueiroga.vibee.repositories.LocalizationRepository;

@Service
public class LocalizationService {

	@Autowired
	private LocalizationRepository repository;

	public List<Localization> findAll() {
		return repository.findAll();
	}

	public Localization findById(Long id) {
		Optional<Localization> obj = repository.findById(id);
		return obj.get();
	}
}
