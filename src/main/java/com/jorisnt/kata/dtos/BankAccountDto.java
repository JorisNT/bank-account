package com.jorisnt.kata.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class BankAccountDto {
  private Long bankAccountId;
  private String username;
  private BigDecimal balance;
  private Instant creationDate;
  private List<TransactionDto> transactions;
}
