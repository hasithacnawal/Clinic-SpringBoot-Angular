package com.surreytech.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surreytech.demo.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
		Doctor findByName(String name);
		

}
