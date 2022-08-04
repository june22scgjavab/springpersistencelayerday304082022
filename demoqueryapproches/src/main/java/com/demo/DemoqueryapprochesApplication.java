package com.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.entity.Customer;
import com.demo.repository.CustomerRepository;

@SpringBootApplication
public class DemoqueryapprochesApplication implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoqueryapprochesApplication.class, args);
       //addCustomer();
       
	}

	private void searchOnCustomerId() {
		int customerId=2;
		Customer customer=(Customer)repository.findById(customerId).get();
		System.out.print(customer.getName()+" "+customer.getEmailId()+"\n");
		
	}

	private  void addCustomer() {
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		//searchOnCustomerId();
	      //searchOnName();
	      //searchDateOfBirthAfterADate();
	      searchName();
		
	}

	private void searchName() {
		String name=repository.findNames("james@infy.com");
		System.out.println(name);
		
	}

	private void searchDateOfBirthAfterADate() {
		LocalDate date=LocalDate.of(1999, 01, 01);
		//List<Customer> custList=repository.findMedateOfBirthAfter(date);  //java.lang.IllegalArgumentException: 
		//List<Customer> custList=repository.findBydateOfBirthAfter(date);
		//List<Customer> custList=repository.method1(date);
		
		//System.out.println(custList);
		 
		
	}

	private void searchOnName() {
		//Customer customer=repository.findByName("martin");//NonUniqueResultException So multiple entry for Martin
		//Customer customer=repository.findByName("john");
		 //Customer customer=repository.findName("John");
		//System.out.println("------------DETAILS------------------------");
		//System.out.println(customer.getEmailId()+"  "+customer.getDateOfBirth());
	}

	
}
