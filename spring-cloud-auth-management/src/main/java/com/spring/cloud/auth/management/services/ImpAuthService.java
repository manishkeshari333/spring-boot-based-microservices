package com.spring.cloud.auth.management.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.cloud.auth.management.dao.RoleRepo;
import com.spring.cloud.auth.management.dao.UserRepo;
import com.spring.cloud.auth.management.dto.LoginRequest;
import com.spring.cloud.auth.management.entity.Role;
import com.spring.cloud.auth.management.entity.User;

@Service
public class ImpAuthService implements AuthService {

	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	private final PasswordEncoder passwordEncoder;

	public ImpAuthService(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User registerUser(LoginRequest request) {

		User user = new User();
		user.setUserName(request.getUserName());
		user.setPassword(passwordEncoder.encode(request.getPassWord()));
		Set<Role> roles = new HashSet<>();
		for (Role roleId : request.getRoles()) { // Assuming you pass role IDs in the request
			Role role = roleRepo.findById(roleId.getId()).orElseThrow(() -> new RuntimeException("Role not found"));
			roles.add(role);
		}

		user.setRoles(roles);

		return userRepo.save(user);
	}

}
