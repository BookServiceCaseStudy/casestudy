package com.book.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableSidecar
public class BookRegistrationGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookRegistrationGatewayApplication.class, args);
	}
}
