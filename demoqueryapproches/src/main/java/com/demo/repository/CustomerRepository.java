package com.demo.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {

// Query generation with method name
//Customer findByName(String name);	
// SELECT c FROM Customer WHERE c.name=?1;
//List<Customer> findBydateOfBirthAfter(LocalDate date);
	
	

//@Query("SELECT c FROM Customer c WHERE c.name=:customerName")
 //Customer findName(@Param("customerName") String name);
 
 //@Query("SELECT c FROM Customer c WHERE c.dateOfBirth>:givenDate")
 //List<Customer> method1(@Param("givenDate") LocalDate date);
 
 //@Query("SELECT c FROM Customer WHERE c.name=?1")
 //Customer findName(String name);
	
	String findNames(@Param("emailId") String mailId);

}
