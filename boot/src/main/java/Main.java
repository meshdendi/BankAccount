
import io.exaltIt.bankAccount.adapter.AccountManagerAdapter;
import io.exaltIt.bankAccount.data.Account;
import io.exaltIt.bankAccount.data.Bank;
import io.exaltIt.bankAccount.port.AccountManagerPort;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        // create bank
        Bank bank = new Bank();
        AccountManagerPort accountManagerPort = new AccountManagerAdapter(bank);

        // create accounts
        Account account1 = accountManagerPort.createAccount(1L, "John Doe");
        Account account2 = accountManagerPort.createAccount(1L, "Janette Dormamu");

        // acc1 operation
        accountManagerPort.deposit(account1, BigDecimal.valueOf(1000));
        accountManagerPort.withdraw(account1, BigDecimal.valueOf(600));
        accountManagerPort.withdraw(account1, BigDecimal.valueOf(2000));
        accountManagerPort.deposit(account1, BigDecimal.valueOf(750));
        System.out.println(accountManagerPort.printStatement(account1));

        // acc2 operation
        accountManagerPort.deposit(account2, BigDecimal.valueOf(5000));
        accountManagerPort.withdraw(account2, BigDecimal.valueOf(552));
        accountManagerPort.withdraw(account2, BigDecimal.valueOf(3000));
        accountManagerPort.deposit(account2, BigDecimal.valueOf(400));
        System.out.println(accountManagerPort.printStatement(account2));
    }
}
