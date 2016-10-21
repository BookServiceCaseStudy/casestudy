package com.book.messageBroker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan
public class BookRegistrationMessageBrokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookRegistrationMessageBrokerApplication.class, args);
	}
}
