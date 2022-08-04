package com.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.demo.entity.Transaction;

public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Integer> {

}
