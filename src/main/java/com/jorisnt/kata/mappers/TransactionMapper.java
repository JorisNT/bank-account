package com.jorisnt.kata.mappers;

import com.jorisnt.kata.dtos.TransactionDto;
import com.jorisnt.kata.models.Transaction;

public class TransactionMapper {
  public static TransactionDto toDto(Transaction transaction) {
    return TransactionDto.builder()
        .type(transaction.getType())
        .reason(transaction.getReason())
        .amount(transaction.getAmount())
        .creationDate(transaction.getCreationDate())
        .build();
  }
}
