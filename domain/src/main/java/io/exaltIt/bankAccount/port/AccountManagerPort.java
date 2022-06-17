package io.exaltIt.bankAccount.port;

import io.exaltIt.bankAccount.data.Account;

import java.math.BigDecimal;

public interface AccountManagerPort {
    Account createAccount(Long id, String name);
    void deposit(Account account, BigDecimal amount);
    void withdraw(Account account, BigDecimal amount);
    String printStatement(Account account);
}
