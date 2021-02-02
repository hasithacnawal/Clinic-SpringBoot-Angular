package com.surreytech.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Patient {
	
	@Id
	private int id;
	private String name;
	private String address;
	
	@ManyToMany(mappedBy = "patients")
	private List<Doctor> doctors;
	@ManyToMany(mappedBy = "patients")
	private List<Clinic> clinics;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
