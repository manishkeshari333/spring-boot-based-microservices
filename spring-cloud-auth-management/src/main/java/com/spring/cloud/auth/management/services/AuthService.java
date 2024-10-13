package com.spring.cloud.auth.management.services;

import com.spring.cloud.auth.management.dto.LoginRequest;
import com.spring.cloud.auth.management.entity.User;

public interface AuthService {

	User registerUser(LoginRequest request);

}
