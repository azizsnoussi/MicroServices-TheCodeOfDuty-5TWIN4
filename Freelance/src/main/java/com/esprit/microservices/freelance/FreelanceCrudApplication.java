package com.esprit.microservices.freelance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FreelanceCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreelanceCrudApplication.class, args);
	}


}
