package com.jorisnt.kata.services.bankaccount;

import com.jorisnt.kata.dtos.TransactionCreateDto;
import com.jorisnt.kata.models.BankAccount;
import com.jorisnt.kata.models.Transaction;

import java.util.Optional;

public interface BankAccountService {
  BankAccount create(String username);

  Optional<BankAccount> findBankAccountOf(String username);

  Optional<Transaction> placeTransaction(TransactionCreateDto transaction);
}
