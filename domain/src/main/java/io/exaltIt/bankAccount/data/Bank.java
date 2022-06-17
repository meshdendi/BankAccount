package io.exaltIt.bankAccount.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bank {
    private List<Account> accounts;
    public Bank () {
        accounts = new ArrayList<>();
    }
}
