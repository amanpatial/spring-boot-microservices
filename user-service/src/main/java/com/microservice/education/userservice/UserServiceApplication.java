package com.microservice.education.userservice;

// import com.microservice.education.userservice.resource.UserResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// @EnableEurekaClient
@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}
