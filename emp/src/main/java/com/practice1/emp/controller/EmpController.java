package com.practice1.emp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice1.emp.entity.Emp;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmpController {

	@GetMapping("hello")
	public String hello() {
		log.info("hello()....");
		return "Hello Raja....";
	}
	
	@GetMapping("/emp/{empId}")
	public Emp getEmp(@PathVariable("empId") Integer empId) {
		log.info("getEmp()...");
		log.info("PathParam empid: {}",empId);
		return new Emp("name", empId, "deptName", 3000000);
	}
}
