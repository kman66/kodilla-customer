package com.kodilla.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class KodillaCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodillaCustomerApplication.class, args);
	}

}
