package com.practice.employee.controller;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.employee.EmployeeDataSetup;
import com.practice.employee.entity.Employee;

import lombok.extern.slf4j.Slf4j;

@RestController
//@Controller
@Slf4j
public class EmpController {

//	@GetMapping("/hello")
	@RequestMapping("/hello")
	public String get(@RequestParam(value = "name", defaultValue = "Naga", required = false) String name) {
		System.out.println("get()..." + "hello " + name);
		return "hello " + name;
	}

	@RequestMapping("/emp/{empId}")
//	@ResponseBody
	@GetMapping("/emp/{empId}")
	public Optional<Employee> getEmp(@PathVariable("empId") Integer empId) {
		log.info("getEmp()...");
		log.info("Path param empId : {}", empId);
		Optional<Employee> findFirst = EmployeeDataSetup.empList.stream().filter(e -> e.getId() == empId).findFirst();
		return findFirst;
	}

	@RequestMapping("/empGroupBy")
	public Map<Integer, List<Employee>> empGroupBy() {
		log.info("emp Group By");
//		EmployeeDataSetup.empList.parallelStream().empGroupBy(Employee::getId);
		Map<Integer, List<Employee>> map = EmployeeDataSetup.empList.parallelStream()
				.collect(Collectors.groupingBy(Employee::getId));
		return map;
	}

	@RequestMapping("groupStat")
	public Map<Integer, Long> groupStat() {
		log.info("groupStat");
		Map<Integer, Long> collect = EmployeeDataSetup.empList.stream()
				.collect(Collectors.groupingBy(Employee::getId, Collectors.counting()));
		log.info("Group stats : {}", collect);
		return collect;
	}

	@RequestMapping("duplicateCount")
	public Map<Integer, Long> duplicateCount() {
		Map<Integer, Long> collect = EmployeeDataSetup.empList.parallelStream()
				.collect(Collectors.groupingBy(Employee::getId, Collectors.counting()));
		Map<Integer, Long> result = collect.entrySet().stream().filter(e -> e.getValue() > 1)
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
		log.info("duplicats : {}", result);
		log.info("duplicat empIds : {}", result.size());
		log.info("Duplicates count ; {}", result.entrySet().stream().mapToLong(Entry::getValue).sum());
		return result;
	}
	
	@RequestMapping("distinctEmps")
	public List<Employee> distinctEmps(){
		 List<Employee> result = EmployeeDataSetup.empList.stream().distinct().collect(Collectors.toList());
		 log.info("Distinct Emps : {}", result);
		 log.info("Emp count : {}", result.size());
		 IntSummaryStatistics summaryInt = EmployeeDataSetup.empList.stream().collect(Collectors.summarizingInt(Employee::getSalary));
		 log.info("Summary Int : {}", summaryInt.toString());
		 return result;
	}

}
