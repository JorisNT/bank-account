package com.jorisnt.kata.dtos;

import com.jorisnt.kata.models.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TransactionCreateDto {
  private Long bankAccountId;
  private String reason;
  private TransactionType type;
  private BigDecimal amount;
}
