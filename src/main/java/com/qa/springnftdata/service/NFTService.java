package com.qa.springnftdata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springnftdata.entities.NFTInstance;
import com.qa.springnftdata.repos.NFTRepo;

@Service
public class NFTService {

	private NFTRepo repo;
	
	public NFTService(NFTRepo repo) {
		this.repo = repo;
	}
	
	// GET - READ
	// ReadAll
	public List <NFTInstance> readAll(){
		return this.repo.findAll();
	
	}
	
	//ReadByID
	public NFTInstance readById(long id) {
			return this.repo.findById(id).get();
	}
	
	//Read By Name
	public List <NFTInstance> readbyName (String name) {
		return this.repo.findNFTInstanceByName(name);
	}
	
	//POST - CREATE
	public NFTInstance create (NFTInstance nftinstance) {
		return this.repo.saveAndFlush(nftinstance);
	}
	
	// PUT - UPDATE
	public NFTInstance update(long id, NFTInstance nftinstance) {
		//1) Get the existing entry
		NFTInstance existing = this.repo.findById(id).get();
		
		//2) Change the existing entry, using new NFT object above
		existing.setName(nftinstance.getName());
		existing.setBody(nftinstance.getBody());
		existing.setSize(nftinstance.getSize());
		existing.setPegCount(nftinstance.getPegCount());
		existing.setWrapOrientation(nftinstance.getWrapOrientation());
		
		//3) Save the entry back into the database
		return this.repo.saveAndFlush(existing);
	}
	
	//DELETE - DELETE
	public boolean delete(long id) {
		this.repo.deleteById(id);
		
		return !this.repo.existsById(id); // this should be false
	}
	
	
}

