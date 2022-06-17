package io.exaltIt.bankAccount.data;

import io.exaltIt.bankAccount.Constant;
import io.exaltIt.bankAccount.data.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountLine {
    private OperationType operationType;
    private BigDecimal amount;
    private LocalDateTime operationDate;

    @Override
    public String toString() {
        return String.format(
                Constant.ACCOUNT_LINE_STATEMENT_FORMAT,
                operationType,
                amount.toString(),
                operationDate.format(DateTimeFormatter.ofPattern(Constant.DATE_TIME_FORMAT))
        );
    }
}
