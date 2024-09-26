package com.mfqueiroga.vibee.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mfqueiroga.vibee.entities.Beehive;
import com.mfqueiroga.vibee.services.BeehiveService;

@RestController
@RequestMapping(value = "/beehives")
public class BeehiveResource {

	@Autowired
	private BeehiveService service;
	
	@GetMapping
	public ResponseEntity<List<Beehive>> findAll(){
		List<Beehive> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Beehive> findById(@PathVariable Long id){
		Beehive obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Beehive> insert(@RequestBody Beehive obj){
		System.out.println(obj);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
