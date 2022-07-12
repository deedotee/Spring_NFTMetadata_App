package com.qa.springnftdata.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NFTInstance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NFT Instance name", nullable = false, unique = true)
	private String Name;
	
	@Column(nullable = false)
	private String body;
	
	@Column(nullable = false)
	private String size;
	
	@Column(nullable = false)
	private int pegCount;
	
	@Column(nullable = false)
	private String wrapOrientation;

	// Default constructor 
	public NFTInstance() {}
	
	// No ID constructor 
	public NFTInstance(String name, String body, String size, int pegCount, String wrapOrientation) {
		super();
		Name = name;
		this.body = body;
		this.size = size;
		this.pegCount = pegCount;
		this.wrapOrientation = wrapOrientation;
	}
	
	// All args constructor
	public NFTInstance(long id, String name, String body, String size, int pegCount, String wrapOrientation) {
		super();
		this.id = id;
		Name = name;
		this.body = body;
		this.size = size;
		this.pegCount = pegCount;
		this.wrapOrientation = wrapOrientation;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getPegCount() {
		return pegCount;
	}

	public void setPegCount(int pegCount) {
		this.pegCount = pegCount;
	}

	public String getWrapOrientation() {
		return wrapOrientation;
	}

	public void setWrapOrientation(String wrapOrientation) {
		this.wrapOrientation = wrapOrientation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Name, body, id, pegCount, size, wrapOrientation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NFTInstance other = (NFTInstance) obj;
		return Objects.equals(Name, other.Name) && Objects.equals(body, other.body) && id == other.id
				&& pegCount == other.pegCount && Objects.equals(size, other.size)
				&& Objects.equals(wrapOrientation, other.wrapOrientation);
	}
	
	
	

}
