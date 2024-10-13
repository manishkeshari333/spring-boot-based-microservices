package com.spring.cloud.patient.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patientlocation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	private String state;
	private Long zipcode;
	private String city;
	private String currentLocation;
}
