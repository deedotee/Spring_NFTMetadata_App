package com.qa.springnftdata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springnftdata.entities.NFTInstance;

@Service
public class NFTService {

	private NFTInstance repo;
	
	public NFTInstance(NFTInstancerepo repo) {
		this.repo = repo;
		
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
	public List <NFTInstance> readbyName (String Name) {
		return this.repo.findNFTByName(name)
	}
	
	//POST - CREATE
	public NFTInstance create (NFTInstance nftinstance) {
		return this.repo.saveAndFlush(NFTInstance);
	}
	
	// PUT - UPDATE
	public NFTInstance update(long id, NFTInstance nftinstance) {
		//1) Get the existing entry
		NFTIsntance existing = this.repo.findbyID(id).get();
		
		//2) Change the existing entry, using new NFT object above
		existing.setName(NFTInstance.getName());
		existing.setBody(NFTInstance.getBody();)
		existing.setSize(NFTInstance.getSize());
		existing.setpegCount(NFTInstance.getPegCount());
		existing.setWrapOrientation(NFTInstance.getWrapOrientation());
		
		//3) Save the entry back into the database
		return this.repo.SaveandFlush(existing);
		
	//DELETE - DELETE
	public boolean delete(ling id) {
		this.repo.deleteById(id);
		
		return !this.repo.existsById(id); // this should be false
	}
		
	}
	
	
	
	
	}
	
	
}
