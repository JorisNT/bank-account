package com.jorisnt.kata.mappers;

import com.jorisnt.kata.dtos.BankAccountDto;
import com.jorisnt.kata.models.BankAccount;

import java.util.stream.Collectors;

public class BankAccountMapper {
  public static BankAccountDto toDto(BankAccount account) {
    return BankAccountDto.builder()
        .bankAccountId(account.getBankAccountId())
        .balance(account.getBalance())
        .username(account.getUsername())
        .creationDate(account.getCreationDate())
        .transactions(account.getTransactions().stream()
            .map(TransactionMapper::toDto)
            .collect(Collectors.toList()))
        .build();
  }
}
