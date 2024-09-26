package com.mfqueiroga.vibee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mfqueiroga.vibee.entities.Beehive;
import com.mfqueiroga.vibee.entities.User;
import com.mfqueiroga.vibee.entities.Localization;
import com.mfqueiroga.vibee.repositories.BeehiveRepository;
import com.mfqueiroga.vibee.repositories.UserRepository;
import com.mfqueiroga.vibee.repositories.LocalizationRepository;

@Service
public class BeehiveService {

	@Autowired
	private BeehiveRepository repository;

	@Autowired
	private LocalizationRepository localizationRepository;

	@Autowired
	private UserRepository userRepository;

	public List<Beehive> findAll() {
		return repository.findAll();
	}

	public Beehive findById(Long id) {
		Optional<Beehive> obj = repository.findById(id);
		return obj.get();
	}

	@Transactional
	public Beehive insert(Beehive obj) {
		System.out.println(obj);
		User user = userRepository.getOne(obj.getUser().getId());

		Localization localization = obj.getLocal();
		localization = localizationRepository.save(localization);
		
		Beehive bh = new Beehive();
		bh.setLocal(localization);
		bh.setBee(obj.getBee());
		bh.setUser(user);
		bh = repository.save(obj);

		return new Beehive(bh.getId(), bh.getBee(), bh.getLocal(), bh.getUser());
	}

}
