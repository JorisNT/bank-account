package com.jorisnt.kata.services.bankaccount;

import com.jorisnt.kata.dtos.TransactionCreateDto;
import com.jorisnt.kata.models.BankAccount;
import com.jorisnt.kata.models.Transaction;
import com.jorisnt.kata.repositories.BankAccountRepository;
import com.jorisnt.kata.services.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;

import static com.jorisnt.kata.utils.BankAccountUtil.applyUpdateAccountBalance;
import static com.jorisnt.kata.utils.BankAccountUtil.applyUpdateAccountTransactions;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

  private final BankAccountRepository repository;
  private final TransactionService transactionService;

  @Override
  public BankAccount create(String username) {
    var account = BankAccount.builder()
        .username(username)
        .balance(BigDecimal.ZERO)
        .creationDate(Instant.now())
        .build();
    return repository.save(account);
  }

  @Override
  public Optional<BankAccount> findBankAccountOf(String username) {
    return repository.findByUsername(username);
  }

  @Override
  public Optional<Transaction> placeTransaction(TransactionCreateDto transaction) {
    return repository.findById(transaction.getBankAccountId()).map(dbAccount -> {
      var createdTransaction = transactionService.create(transaction);

      Optional.of(dbAccount)
          .map(account -> applyUpdateAccountBalance(account, createdTransaction))
          .map(account -> applyUpdateAccountTransactions(account, createdTransaction))
          .ifPresent(repository::save);

      return createdTransaction;
    });
  }
}
