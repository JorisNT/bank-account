package com.jorisnt.kata.controllers;

import com.jorisnt.kata.dtos.*;
import com.jorisnt.kata.mappers.BankAccountMapper;
import com.jorisnt.kata.mappers.TransactionMapper;
import com.jorisnt.kata.services.bankaccount.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/account")
public class BankAccountController {
  private final BankAccountService bankAccountService;

  @PostMapping("/create")
  public ResponseEntity create(@RequestBody UsernameDto dto) {
    var createdAccount = bankAccountService.create(dto.getUsername());
    return ResponseEntity
        .created(URI.create("api/account/" + createdAccount.getUsername()))
        .build();
  }

  @GetMapping("/{username}")
  public ResponseEntity<BankAccountDto> get(@PathVariable String username) {
    return bankAccountService
        .findBankAccountOf(username)
        .map(BankAccountMapper::toDto)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/transaction")
  public ResponseEntity<TransactionDto> placeTransaction(@RequestBody TransactionCreateDto transaction) {
    return bankAccountService
        .placeTransaction(transaction)
        .map(TransactionMapper::toDto)
        .map(t -> ResponseEntity.created(null).body(t))
        .orElse(ResponseEntity.badRequest().build());
  }

}
