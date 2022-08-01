package com.jorisnt.kata.services.transaction;

import com.jorisnt.kata.dtos.TransactionCreateDto;
import com.jorisnt.kata.models.Transaction;
import com.jorisnt.kata.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

  private final TransactionRepository repository;

  @Override
  public Transaction create(TransactionCreateDto transaction) {
    return repository.save(Transaction.builder()
        .reason(transaction.getReason())
        .type(transaction.getType())
        .amount(transaction.getAmount())
        .creationDate(Instant.now())
        .build());
  }
}
