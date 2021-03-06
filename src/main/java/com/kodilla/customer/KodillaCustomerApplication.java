package com.kodilla.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.netflix.client.config.IClientConfig", "com.kodilla.customer"})
public class KodillaCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodillaCustomerApplication.class, args);
	}

}
