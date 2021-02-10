package com.surreytech.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surreytech.demo.entity.Patient;
import com.surreytech.demo.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository repository;
	
	public List<Patient> getAll() {
		return  repository.findAll();
	}
	
	public Patient getById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Patient getByName(String name) {
		return repository.findByName(name);
	}
	public Patient savePatient(Patient patient) {
		return repository.save(patient);
	}
	
	public String updatePatient(Patient newPatient) {
		Patient existingPatient = repository.findById(newPatient.getId()).orElse(null);
		
		existingPatient.setName(newPatient.getName());
		existingPatient.setAddress(newPatient.getAddress());
		existingPatient.setNic(newPatient.getNic());
		
		return "Patient"+existingPatient.getName()+"UPDATED";
	}
	

}
