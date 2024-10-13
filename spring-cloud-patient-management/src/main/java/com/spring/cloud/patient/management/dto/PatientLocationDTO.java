package com.spring.cloud.patient.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientLocationDTO {
	private Long id;
	private String state;
	private Long zipcode;
	private String city;
	private String currentLocation;
}
