package com.surreytech.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surreytech.demo.entity.Clinic;
import com.surreytech.demo.entity.Doctor;


public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
	List<Clinic> findByDoctor(Doctor doctor);
	
	
}
