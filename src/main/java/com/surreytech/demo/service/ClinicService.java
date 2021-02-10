package com.surreytech.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surreytech.demo.entity.Clinic;
import com.surreytech.demo.entity.Doctor;
import com.surreytech.demo.repository.ClinicRepository;
import com.surreytech.demo.repository.DoctorRepository;

@Service
public class ClinicService {

	@Autowired
	private ClinicRepository clinicRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	
	
	public List<Clinic> getAll() {
		return clinicRepository.findAll();
	}
	public Clinic getById(int id) {
		return clinicRepository.findById(id).orElse(null);
	}
	
	public List<Clinic> getByDoctorId(int doctorId) {
		Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
		return clinicRepository.findByDoctor(doctor);
	}
	
	public Clinic saveClinic(Clinic clinic) {
		return clinicRepository.save(clinic);
			
	}
	
	public List<Clinic> saveClinics(List<Clinic> clinics) {
		return clinicRepository.saveAll(clinics);
	}
	
}
