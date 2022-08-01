package com.jorisnt.kata.services.transaction;

import com.jorisnt.kata.dtos.TransactionCreateDto;
import com.jorisnt.kata.models.Transaction;

public interface TransactionService {
  Transaction create(TransactionCreateDto transaction);
}
