package com.spring.cloud.patient.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.patient.management.entity.Patient;
import com.spring.cloud.patient.management.services.PatientService;

@RestController
@RequestMapping("/api/v1/patmang")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
		Patient patient = patientService.getPatientById(id);
		return patient != null ? ResponseEntity.ok(patient) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
		Patient createdPatient = patientService.createPatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable String id, @RequestBody Patient patient) {
		Patient updatedPatient = patientService.updatePatient(id, patient);
		return updatedPatient != null ? ResponseEntity.ok(updatedPatient) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePatient(@PathVariable String id) {
		patientService.deletePatient(id);
		return ResponseEntity.noContent().build();
	}

}
