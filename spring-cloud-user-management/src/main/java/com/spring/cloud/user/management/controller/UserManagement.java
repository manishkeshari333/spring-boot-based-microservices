package com.spring.cloud.user.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usrmang")
public class UserManagement {

	@GetMapping("/register")
	public String userRegister() {
		return "User register Sucesfully";
	}
}
