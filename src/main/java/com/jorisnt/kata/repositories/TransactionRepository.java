package com.jorisnt.kata.repositories;

import com.jorisnt.kata.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
