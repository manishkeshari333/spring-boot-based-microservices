package com.spring.cloud.patient.management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cloud.patient.management.entity.Patient;
import com.spring.cloud.patient.management.exception.ErrorCode;
import com.spring.cloud.patient.management.exception.PatientException;
import com.spring.cloud.patient.management.repo.PatientRepository;

import jakarta.transaction.Transactional;

@Service
public class ImpPatientService implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(String id) {
		return patientRepository.findById(id).orElse(null);
	}

	@Override
	public Patient createPatient(Patient patient) {

		Optional<Patient> existingPatient = patientRepository.findByEmailAndContactInfo(patient.getEmail(),
				patient.getContactInfo());
		if (existingPatient.isPresent()) {
			throw new PatientException(ErrorCode.DUBLICATE_NOT_ALLOW,
					"A patient with this contact information or email already exists.");
		}

		return patientRepository.save(patient);
	}

	@Override
	@Transactional
	public Patient updatePatient(String id, Patient patient) {
		patient.setId(id);
		return patientRepository.save(patient);
	}

	@Override
	public void deletePatient(String id) {
		patientRepository.deleteById(id);
	}

}
