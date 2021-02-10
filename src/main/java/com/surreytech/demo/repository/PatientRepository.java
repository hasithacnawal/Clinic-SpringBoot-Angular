package com.surreytech.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surreytech.demo.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
Patient findByName(String name);
Patient findByNic(String nic);

}
