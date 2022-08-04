package com.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.demo.entity.Transaction;
import com.demo.repository.TransactionRepository;

@SpringBootApplication
public class DemopaginationandsortingApplication implements CommandLineRunner{

	@Autowired
	TransactionRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(DemopaginationandsortingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//paginatedDetails();
		//sortingOnTrasactionDateAscending();
		//sortingOnTrasactionDateDescending();
		sortingOnTrasactionDateDescendingAndAmountAscending();
		
	}

	private void sortingOnTrasactionDateDescendingAndAmountAscending() {
		Iterable<Transaction> beforeSort=  repository.findAll();
		for(Transaction trans : beforeSort) {
			System.out.println(trans.getTransactionId()+" "+trans.getTransactionDate()+" "+trans.getTransactionAmount());	
		}
		System.out.println("-----------------------------------------------------------------------------");
		Sort sort=Sort.by("transactionDate").descending().and(Sort.by("transactionAmount").descending());
		Iterable<Transaction> transactions=repository.findAll(sort);
		for(Transaction trans : transactions) {
			System.out.println(trans.getTransactionId()+" "+trans.getTransactionDate()+" "+trans.getTransactionAmount());	
		}	
			
		
	}

	private void sortingOnTrasactionDateDescending() {
		Iterable<Transaction> beforeSort=  repository.findAll();
		for(Transaction trans : beforeSort) {
			System.out.println(trans.getTransactionId()+" "+trans.getTransactionDate()+" "+trans.getTransactionAmount());	
		}
		System.out.println("-----------------------------------------------------------------------------");
		Sort sort=Sort.by("transactionDate").descending();
		Iterable<Transaction> transactions=repository.findAll(sort);
		for(Transaction trans : transactions) {
			System.out.println(trans.getTransactionId()+" "+trans.getTransactionDate()+" "+trans.getTransactionAmount());	
		}	
		
	}

	private void sortingOnTrasactionDateAscending() {
		Iterable<Transaction> beforeSort=  repository.findAll();
		for(Transaction trans : beforeSort) {
			System.out.println(trans.getTransactionId()+" "+trans.getTransactionDate()+" "+trans.getTransactionAmount());	
		}
		System.out.println("-----------------------------------------------------------------------------");
		Sort sort=Sort.by("transactionDate");
		Iterable<Transaction> transactions=repository.findAll(sort);
		for(Transaction trans : transactions) {
			System.out.println(trans.getTransactionId()+" "+trans.getTransactionDate()+" "+trans.getTransactionAmount());	
		}
		
	}

	private void paginatedDetails() {
		// STEP1 We have to create an Object of Pageable ( which means an object of a class
		// which has implemented the Pageable Interface and the class is PageRequest
		Pageable transactions=PageRequest.of(1, 5);
		// STEP2 We have to create an object of Page which will be returned by findAll method
		//of repository
		Page<Transaction> page=repository.findAll(transactions);
		// STEP3 through page object we will invoke getContent method which will return a List of Transactions
		List<Transaction> theTransactions=page.getContent();
		for(Transaction trans : theTransactions)
		{
			System.out.println(trans.getTransactionId()+" "+trans.getTransactionDate()+" "+trans.getTransactionAmount());
		}
	}

}
