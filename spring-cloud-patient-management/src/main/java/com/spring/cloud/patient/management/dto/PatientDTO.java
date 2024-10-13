package com.spring.cloud.patient.management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
	
	private String id;

	private String firstName;

	private String lastName;

	@Email(message = "Email should be valid")
	@NotBlank(message = "Email is required")
	private String email;

	private Long age;

	private String gender;

	@NotBlank(message = "Contact information is required")
	private String contactInfo;

	private PatientLocationDTO location;
}
