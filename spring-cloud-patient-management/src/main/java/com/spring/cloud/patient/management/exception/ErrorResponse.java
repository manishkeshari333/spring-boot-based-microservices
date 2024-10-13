package com.spring.cloud.patient.management.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

	private String message;
	private int status;
	private LocalDateTime timestamp;
}
