package com.practice.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.practice.employee.entity.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeDataSetup {
	private static final int empMaxBeanCount = 200;
	private static final Random empIdRandom = new Random();
	private static final int deptMaxBeanCount = 10;
	private static final Random deptRandom = new Random();
	private static final Random salaryRandom = new Random();

	public static final List<Employee> empList = new ArrayList<Employee>();

	public static void populate() {
		log.info("dataSetup started....");
		for (int count = 0; count < empMaxBeanCount; count++) {
			empList.add(new Employee("name" + count, empIdRandom.nextInt(empMaxBeanCount), "deptName" + deptRandom.nextInt(deptMaxBeanCount),
					salaryRandom.nextInt(500) * 10000));
		}
		log.info("Emp list size : {}", empList.size());
		log.info("emp list {}",empList.parallelStream().map(Employee :: toString).collect(Collectors.joining("\n\t")));
		log.info("dataSetup End !");
	}

}
