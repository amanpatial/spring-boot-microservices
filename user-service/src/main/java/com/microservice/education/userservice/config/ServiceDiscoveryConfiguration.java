package com.microservice.education.userservice.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
/**
 * Eureka service discovery client configuration
 *
 **/
@Configuration
@EnableDiscoveryClient
public class ServiceDiscoveryConfiguration {
}
