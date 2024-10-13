package com.spring.cloud.patient.management.exception;

public class PatientException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final ErrorCode errorCode;

	public PatientException(ErrorCode errorCode,String messge) {
		super(messge);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

}
