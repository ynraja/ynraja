package com.practice1.emp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Emp {
	private String name;
	private Integer empId;
	private String deptName;
	private Integer salary;

}
