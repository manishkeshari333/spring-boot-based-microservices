package com.spring.cloud.auth.management.dto;

import java.util.Set;

import com.spring.cloud.auth.management.entity.Role;

import lombok.Data;

@Data
public class LoginRequest {
    private String userName;
    private String passWord;
    private Set<Role> roles;

}
