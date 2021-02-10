package com.surreytech.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.surreytech.demo.entity.Patient;
import com.surreytech.demo.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientService service;
	
	@PostMapping("/addPatient")
	public Patient addPatient(@RequestBody Patient patient) {
		LOGGER.trace("::New Patient Added :::: PatientController :: addPatient ");
		return service.savePatient(patient);
	}
	
	@GetMapping("/getAll")
	public List<Patient> getAllPatients() {
		return service.getAll();		
	}
	@GetMapping("/getById")
	public Patient getPatientById(@RequestParam("id") int id) {
		return service.getById(id);
	}
	
}
