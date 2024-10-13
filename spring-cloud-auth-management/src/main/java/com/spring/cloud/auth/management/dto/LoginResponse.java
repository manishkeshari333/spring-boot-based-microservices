package com.spring.cloud.auth.management.dto;

import java.util.Set;


import lombok.Data;

@Data
public class LoginResponse {

    private String jwtToken;
    private String userName;
    private Set<String> roles;
}
