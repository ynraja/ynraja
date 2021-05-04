package com.practice.employee;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeeApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	
	@PostConstruct
	public void prepareEmpData() {
		log.info("emp postConstruct called...");
		EmployeeDataSetup.populate();
	}
}
