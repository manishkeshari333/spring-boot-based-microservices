package com.spring.cloud.patient.management.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

	RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not found"), BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad request"),
	DUBLICATE_NOT_ALLOW(HttpStatus.CONFLICT, " Duplicate entry detected");
	// Add more error codes as needed

	private final HttpStatus status;
	private final String message;

	private ErrorCode(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

}
