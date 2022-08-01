package com.jorisnt.kata.utils;

import com.jorisnt.kata.models.BankAccount;
import com.jorisnt.kata.models.Transaction;
import com.jorisnt.kata.models.TransactionType;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankAccountUtil {

  public static BankAccount applyUpdateAccountBalance(BankAccount account, Transaction transaction) {
    var floatingValue = getFloatingValue(transaction.getAmount(), transaction.getType());
    return account.toBuilder()
        .balance(account.getBalance().add(floatingValue))
        .build();
  }

  public static BankAccount applyUpdateAccountTransactions(BankAccount account, Transaction transaction) {
    return account.toBuilder()
        .transactions(
            Stream.concat(account.getTransactions().stream(), Stream.of(transaction))
                .collect(Collectors.toList()))
        .build();
  }

  public static BigDecimal getFloatingValue(BigDecimal value, TransactionType type) {
    switch (type) {
      case CREDIT: return value.abs();
      case DEBIT: return value.abs().negate();
      default: return BigDecimal.ZERO;
    }
  }
}
