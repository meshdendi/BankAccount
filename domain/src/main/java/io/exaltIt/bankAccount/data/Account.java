package io.exaltIt.bankAccount.data;

import io.exaltIt.bankAccount.Constant;
import io.exaltIt.bankAccount.data.enums.OperationType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public class Account {
    private Long id;
    private String customerName;
    private LocalDateTime createdDate;
    private List<AccountLine> accountLines;

    public Account () {
        accountLines = new ArrayList<>();
    }

    public Account(Long id, String customerName, LocalDateTime createdDate) {
        this.id = id;
        this.customerName = customerName;
        this.createdDate = createdDate;
        this.accountLines = new ArrayList<>();;
    }

    @Override
    public String toString() {
        StringBuilder accountingLinesFormatted = new StringBuilder();
        accountLines.forEach(accln -> accountingLinesFormatted.append(accln.toString()));
        return "\n************** Start account statement ****************\n\n" +
                "* \tAccount holder: " + customerName + "\n" +
                "* \tCreated at " + createdDate.format(DateTimeFormatter.ofPattern(Constant.DATE_TIME_FORMAT)) + "\n" +
                "* \tOperations: \n\n" + accountingLinesFormatted + "\n" +
                "* \tBalance: " + getBalance() + "\n\n" +
                "************** End account statement ****************\n" ;
    }

    public BigDecimal getBalance() {
        BigDecimal balance = BigDecimal.ZERO;
        if (accountLines == null) return balance;
        return accountLines.stream()
                .map(accountLine -> accountLine.getOperationType().equals(OperationType.DEBIT) ? accountLine.getAmount().negate() : accountLine.getAmount())
                .reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }
}
