package com.spring.cloud.patient.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringCloudPatientManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudPatientManagementApplication.class, args);
	}

}
