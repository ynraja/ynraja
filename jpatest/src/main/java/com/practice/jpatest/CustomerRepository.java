package com.practice.jpatest;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	public List<Customer> findByLastName(String lastname);
	
}
