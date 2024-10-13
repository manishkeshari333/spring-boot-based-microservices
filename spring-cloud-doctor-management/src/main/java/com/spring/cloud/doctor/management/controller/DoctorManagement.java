package com.spring.cloud.doctor.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/drtmang")
public class DoctorManagement {

	@GetMapping("/register")
	public String patientRegister() {
		return "doctor register Sucesfully";
	}
}
