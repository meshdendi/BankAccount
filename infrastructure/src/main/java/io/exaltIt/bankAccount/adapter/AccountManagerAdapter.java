package io.exaltIt.bankAccount.adapter;

import io.exaltIt.bankAccount.data.Account;
import io.exaltIt.bankAccount.data.AccountLine;
import io.exaltIt.bankAccount.data.Bank;
import io.exaltIt.bankAccount.data.enums.OperationType;
import io.exaltIt.bankAccount.exception.AccountNotFoundException;
import io.exaltIt.bankAccount.port.AccountManagerPort;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountManagerAdapter implements AccountManagerPort {

    private Bank bank;

    public AccountManagerAdapter (Bank bank) {
        this.bank = bank;
    }

    private Account getAccount(long accountId) {
        return bank.getAccounts().stream()
                .filter(acc -> acc.getId() == accountId)
                .findFirst().orElseThrow(AccountNotFoundException::new);
    }

    @Override
    public Account createAccount(Long id, String name) {
        Account account = new Account(id, name, LocalDateTime.now());
        bank.getAccounts().add(account);
        return account;
    }

    @Override
    public void deposit(Account account, BigDecimal amount) {
        AccountLine accountLine = AccountLine.builder()
                .amount(amount)
                .operationType(OperationType.CREDIT)
                .operationDate(LocalDateTime.now())
                .build();
        account.getAccountLines().add(accountLine);
    }

    @Override
    public void withdraw(Account account, BigDecimal amount) {
        AccountLine accountLine = AccountLine.builder()
                .amount(amount)
                .operationType(OperationType.DEBIT)
                .operationDate(LocalDateTime.now())
                .build();
        account.getAccountLines().add(accountLine);
    }

    @Override
    public String printStatement(Account account) {
        return account.toString();
    }

}
