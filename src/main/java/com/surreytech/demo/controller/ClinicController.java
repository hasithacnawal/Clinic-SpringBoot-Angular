package com.surreytech.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.surreytech.demo.entity.Clinic;

import com.surreytech.demo.service.ClinicService;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

	@Autowired
	private ClinicService service;
	
	
	@PostMapping("/")
	public Clinic addClinic(@RequestBody Clinic clinic) {
		
			return service.saveClinic(clinic);
		
	}
	@PostMapping("/all")
	public List<Clinic> addClinics(@RequestBody List<Clinic> clinics){
		return service.saveClinics(clinics);
	}
	
	@GetMapping("/")
	public List<Clinic> getAllClinics() {
		return service.getAll();		
	}
	@GetMapping("/getById")
	public Clinic getById(@RequestParam("id") int id) {
		return service.getById(id);
	}
	@GetMapping("/getByDoctorId/{doctorId}")
	public List<Clinic> getByDoctorId(@PathVariable int doctorId) {
		
		return service.getByDoctorId(doctorId);
	}
	

	
}
