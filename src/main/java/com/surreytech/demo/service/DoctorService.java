package com.surreytech.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surreytech.demo.entity.Doctor;
import com.surreytech.demo.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
		
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	public List<Doctor> saveDoctors(List<Doctor> doctors) {
		return doctorRepository.saveAll(doctors);
	}
	
	public List<Doctor> getDoctors(){
		return doctorRepository.findAll();
	}
	public Doctor getDoctorById(int id) {
		return doctorRepository.findById(id).orElse(null);
	}
	public Doctor getDoctorByName(String name) {
		return doctorRepository.findByName(name);
	}
	
	public String deleteDoctor(int id) {
		doctorRepository.deleteById(id);
		return "Deleted Doctor";
	}
	public Doctor updateDoctor(Doctor newDoctor) {
		Doctor existingDoctor=doctorRepository.findById(newDoctor.getId()).orElse(null);
		
		existingDoctor.setName(newDoctor.getName());
		existingDoctor.setMail(newDoctor.getMail());	
		return doctorRepository.save(existingDoctor);
		
	}
}
