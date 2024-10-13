package com.spring.cloud.patient.management.services;

import java.util.List;

import com.spring.cloud.patient.management.entity.Patient;

public interface PatientService {

	List<Patient> getAllPatients();

	Patient getPatientById(String id);

	Patient createPatient(Patient patient);

	Patient updatePatient(String id, Patient patient);

	void deletePatient(String id);

}
