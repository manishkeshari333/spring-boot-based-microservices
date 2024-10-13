package com.spring.cloud.patient.management.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medicalhistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
    private String disease;
    private LocalDate diagnosisDate;
    private String treatment;
    private String doctorName;
//    private List<Prescription> prescriptions;

}
