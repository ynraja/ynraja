package com.practice1.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpApplicationStartup {

	public static void main(String[] args) {
		System.out.println("Main() start....");
		SpringApplication.run(EmpApplicationStartup.class, args);
		System.out.println("Main() Completed....");
	}

}
