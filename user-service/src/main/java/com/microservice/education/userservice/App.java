package com.microservice.education.userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.microservice.education.userservice",
        "com.microservice.education.userservice.service",
        "com.microservice.education.userservice.repositories"})
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        LOGGER.info("User service is up and running...");
        /* to enable and test lombok
        Order order = new Order();
        order.setOrderId("1");
        System.out.println(order.getOrderId()); */
    }
}
