package com.mfqueiroga.vibee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfqueiroga.vibee.entities.Notification;
import com.mfqueiroga.vibee.repositories.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;
	
	public List<Notification> findAll(){
		return repository.findAll();
	}
	
	public Notification findById(Long id) {
		Optional<Notification> obj = repository.findById(id);
		return obj.get();
	}
}
