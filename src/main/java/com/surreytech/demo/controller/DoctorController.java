package com.surreytech.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surreytech.demo.entity.Doctor;
import com.surreytech.demo.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService service;
	
	@PostMapping("/adddoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return service.saveDoctor(doctor);
	}
	@PostMapping("/adddoctors")
	public List<Doctor> addDoctor(@RequestBody List<Doctor> doctors) {
		return service.saveDoctors(doctors);
	}
	
	@GetMapping("/getall")
	public List<Doctor> findAllDoctors() {
		return service.getDoctors();
		
	}
	@GetMapping("/getdoctor/{id}")
	public Doctor findDoctorById(@PathVariable int id) {
		return service.getDoctorById(id);
	}
	@GetMapping("/getdoctor/{name}")
	public Doctor findDoctorByName(@PathVariable String name) {
		return service.getDoctorByName(name);
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