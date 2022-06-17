package io.exaltIt.bankAccount.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException() {
        super("Account was not found");
    }

}
