package com.jorisnt.kata.dtos;

import com.jorisnt.kata.models.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class TransactionDto {
  private String reason;
  private TransactionType type;
  private BigDecimal amount;
  private Instant creationDate;
}
