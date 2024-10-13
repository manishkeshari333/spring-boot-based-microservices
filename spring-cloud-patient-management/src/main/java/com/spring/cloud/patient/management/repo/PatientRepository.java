package com.spring.cloud.patient.management.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.cloud.patient.management.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

	Optional<Patient> findByEmailAndContactInfo(String email, String contactInfo);
}
