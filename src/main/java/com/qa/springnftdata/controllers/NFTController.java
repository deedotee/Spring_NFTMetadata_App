package com.qa.springnftdata.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springnftdata.entities.NFTInstance;
import com.qa.springnftdata.service.NFTService;

@RestController
//@RequestMapping
public class NFTController {
	
	private NFTService service;

	// Dependency injection
	public NFTController(NFTService service) {
			this.service = service;
	}
	
	// GET - READ
	// ReadAll
	@GetMapping("/readAll")
	public List<NFTInstance> readAll() {
		return this.service.readAll();
	}
	
	//ReadByID
	@GetMapping("/readById/{id}")
	public NFTInstance readById(@PathVariable int id) {
			return this.service.readById(id);
	}	
			
	// POST - CREATE
	@PostMapping("/create") // localhost:8080/create 
	public NFTInstance create(@RequestBody NFTInstance nftinstance) {
			return this.service.create(nftinstance);
	}
	
	// PUT - UPDATE
	@PutMapping("/update/{id}")
	public NFTInstance update(@PathVariable long id, @RequestBody NFTInstance nftinstance){
			return this.service.update(id, nftinstance);
	}
	
	// DELETE - DELETE
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
			return this.service.delete(id);
	}
	
}
