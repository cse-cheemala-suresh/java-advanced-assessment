package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StorageServiceSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StorageServiceSystemApplication.class, args);
		StorageService ss1 = (StorageService) context.getBean("cloudStorage");
		StorageService ss2 = (StorageService) context.getBean("localStorage");
		StorageService ss3 = (StorageService) context.getBean("localStorage");
		StorageService ss4 = context.getBean(StorageService.class);
		
		ss1.storeFile("local1.txt");
		ss2.storeFile("cloud.txt");
		ss3.storeFile("assignment.txt");
		ss4.storeFile("cloud_assignment.txt");
		
		((ConfigurableApplicationContext) context).close();
	}

}
