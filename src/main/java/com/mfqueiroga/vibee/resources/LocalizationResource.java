package com.mfqueiroga.vibee.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfqueiroga.vibee.entities.Localization;
import com.mfqueiroga.vibee.services.LocalizationService;

@RestController
@RequestMapping(value = "/localizations")
public class LocalizationResource {

	@Autowired
	private LocalizationService service;

	@GetMapping
	public ResponseEntity<List<Localization>> findAll() {
		List<Localization> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Localization> findById(@PathVariable Long id) {
		Localization obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
