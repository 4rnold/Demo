package com.example.eurekawaiterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaWaiterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaWaiterServiceApplication.class, args);
	}

}
