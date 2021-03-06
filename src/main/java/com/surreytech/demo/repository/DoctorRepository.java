package com.surreytech.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surreytech.demo.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
		Doctor findByName(String name);
	List<Doctor> findByMailOrPhone(String mail, String phone);
}
