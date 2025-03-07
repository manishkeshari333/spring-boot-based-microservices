package com.spring.cloud.patient.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.cloud.patient.management.entity.PatientLocation;

@Repository
public interface PatientLocationRepository extends JpaRepository<PatientLocation, String> {
}