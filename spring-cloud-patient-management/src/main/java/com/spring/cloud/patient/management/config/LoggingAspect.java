package com.spring.cloud.patient.management.config;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

	@Around("execution(* com.spring.cloud.patient.management..*(..))")
	public Object logServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		String methodName = joinPoint.getSignature().getName();
		Object[] methodArgs = joinPoint.getArgs();
		log.info("Method " + methodName + " is starting...");
		log.info("Input parameters: " + Arrays.toString(methodArgs));
		Object result = null;
		try {
			joinPoint.proceed();
		} catch (Exception e) {
			log.error("Exception in method " + methodName + ": " + e.getMessage());
			throw e;
		}
		log.info("Method " + methodName + " executed successfully with result: " + result);
		long timeTaken = System.currentTimeMillis() - startTime;
		log.info("Method " + methodName + " took " + timeTaken + " milliseconds.");
		return result;
	}
}