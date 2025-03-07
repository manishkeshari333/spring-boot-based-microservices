package com.spring.cloud.patient.management.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "medication")
@AllArgsConstructor
@NoArgsConstructor
public class Medication {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id; // Unique ID for each medication
	private String medicineName; // Name of the medication
	private String dosage; // Dosage amount (e.g., "500mg")
	private String frequency; // Frequency of administration (e.g., "Twice a day")
	private String usageInstructions; // Detailed instructions for usage (e.g., "Take after meals")
	private Integer quantity; // Number of doses prescribed
	private LocalDateTime startDate; // Start date for the medication
	private LocalDateTime endDate; // End date for the medication

}
