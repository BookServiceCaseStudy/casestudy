package com.book.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookRegistrationOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookRegistrationOrderApplication.class, args);
	}
}
