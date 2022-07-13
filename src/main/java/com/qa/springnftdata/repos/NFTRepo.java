package com.qa.springnftdata.repos;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.springnftdata.entities.NFTInstance;

// JpaRepository requires both the Entity and the datatype for the id column
// Long = Long, int = Integer

@Repository
public interface NFTRepo extends JpaRepository<NFTInstance, Long> {

	// SELECT * FROM customer WHERE name = name
	
	List<NFTInstance> findNFTInstanceByName (String name);

}
