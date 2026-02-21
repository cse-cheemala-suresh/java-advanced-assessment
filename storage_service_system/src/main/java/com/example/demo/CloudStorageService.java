package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("cloudStorage")
@Primary
@Scope("singleton")
public class CloudStorageService implements StorageService{
	public CloudStorageService() {
		System.out.println("CloudStorageService bean created");
	}
	
	@PostConstruct
	public void inti() {
		System.out.println("Cloud Storage Service bean initiated");
	}
	
	@Override
	public void storeFile(String fileName) {
		System.out.println("File Stored in cloud storage: " + fileName);
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Cloud Storage Service bean destroyed");
	}
}
