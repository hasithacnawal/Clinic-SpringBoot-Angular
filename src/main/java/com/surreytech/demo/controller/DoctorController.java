package com.surreytech.demo.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.surreytech.demo.entity.Doctor;

import com.surreytech.demo.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	private static final org.slf4j.Logger  LOGGER = LoggerFactory.getLogger(DoctorController.class);

	
	@Autowired
	private DoctorService service;

	
	@PostMapping("/")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		LOGGER.trace("::New Doctor Added :::: DoctorController :: addDoctor ");
		
		return service.saveDoctor(doctor);
		
	}
	@PostMapping("/addDoctors")
	public List<Doctor> addDoctors(@RequestBody List<Doctor> doctors) {
		LOGGER.trace(":: Doctor List Added :::: DoctorController :: addDoctors ");
		return service.saveDoctors(doctors);
	}
	
	@GetMapping("/")
	public List<Doctor> findAllDoctors() {
		LOGGER.info("::get Doctor list :::: DoctorController :: findAllDoctors ");
		return service.getDoctors();		
	}
	@GetMapping("/getById")
	public Doctor findDoctorById(@RequestParam("id") int id) {
		return service.getDoctorById(id);
	}
	@GetMapping("/getByName")
	public Doctor findDoctorByName(@RequestParam("name") String name) {
		return service.getDoctorByName(name);
		
	}
	@GetMapping("/getByEmailOrPhone")
	public List<Doctor> findByEmailOrPhone(@RequestParam("email")String email, @RequestParam("phone") String phone) {
		LOGGER.info("::get Doctor by emial and phone :::: DoctorController :: findByEmailOrPhone ");
		return service.getByEmailOrPhone(email, phone);
	}
	@PutMapping("/update")
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		return service.updateDoctor(doctor);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteDoctor(@PathVariable int id) {
		return service.deleteDoctor(id);
	}
}