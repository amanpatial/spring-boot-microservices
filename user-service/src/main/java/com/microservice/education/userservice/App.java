package com.microservice.education.userservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages={"com.microservice.education.userservice", "com.microservice.education.userservice.service","com.microservice.education.userservice.repositories"})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
