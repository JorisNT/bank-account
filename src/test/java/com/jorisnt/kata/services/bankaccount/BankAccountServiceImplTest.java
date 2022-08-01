package com.jorisnt.kata.services.bankaccount;

import com.jorisnt.kata.models.BankAccount;
import com.jorisnt.kata.repositories.BankAccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BankAccountServiceImplTest {
  @Mock
  BankAccountRepository repository;

  @InjectMocks
  private BankAccountServiceImpl bankAccountService;


  @Test
  void should_create_bank_account() {
    // given
    String username = "joris";
    Long bankAccountId = 23432L;

    // when
    when(repository.save(any(BankAccount.class))).thenAnswer(i -> {
      var bankAccountArgument = i.getArgument(0, BankAccount.class);
      return bankAccountArgument.toBuilder()
          .bankAccountId(bankAccountId)
          .build();
    });
    var createdAccount = bankAccountService.create(username);

    // then
    assertThat(createdAccount).isNotNull();
    assertThat(createdAccount.getBankAccountId()).isEqualTo(bankAccountId);
    assertThat(createdAccount.getUsername()).isEqualTo(username);
    assertThat(createdAccount.getBalance()).isEqualTo(BigDecimal.ZERO);
    assertThat(createdAccount.getCreationDate()).isNotNull();
    verify(repository, times(1)).save(any());
  }

}