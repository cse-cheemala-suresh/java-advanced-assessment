package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineOrderManagementApplication implements CommandLineRunner{

	 @Autowired
	 private OrderManagementService service;

	public static void main(String[] args) {
		SpringApplication.run(OnlineOrderManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.saveCustomerWithOrders();
        service.fetchCustomer(1L);
	}

}
