package nosql.domain.model;

import java.math.BigDecimal;

/**
 * <b>DDD Layer:</b> Domain Model (NoSQL)
 * <b>DDD Role:</b> Embedded Value Object (JSON Detail)
 *
 * Contains the variable detail data for an AuditLogEntry of type "Transfer".
 * Captures the financial impact of a transfer on both the source
 * and destination accounts at the moment of execution.
 */
public class TransferDetail {

    private BigDecimal amount;
    private BigDecimal balanceBeforeSource;
    private BigDecimal balanceAfterSource;
    private BigDecimal balanceBeforeDestination;
    private BigDecimal balanceAfterDestination;

    public TransferDetail(BigDecimal amount,
                          BigDecimal balanceBeforeSource,
                          BigDecimal balanceAfterSource,
                          BigDecimal balanceBeforeDestination,
                          BigDecimal balanceAfterDestination) {
        this.amount = amount;
        this.balanceBeforeSource = balanceBeforeSource;
        this.balanceAfterSource = balanceAfterSource;
        this.balanceBeforeDestination = balanceBeforeDestination;
        this.balanceAfterDestination = balanceAfterDestination;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalanceBeforeSource() {
        return balanceBeforeSource;
    }

    public void setBalanceBeforeSource(BigDecimal balanceBeforeSource) {
        this.balanceBeforeSource = balanceBeforeSource;
    }

    public BigDecimal getBalanceAfterSource() {
        return balanceAfterSource;
    }

    public void setBalanceAfterSource(BigDecimal balanceAfterSource) {
        this.balanceAfterSource = balanceAfterSource;
    }

    public BigDecimal getBalanceBeforeDestination() {
        return balanceBeforeDestination;
    }

    public void setBalanceBeforeDestination(BigDecimal balanceBeforeDestination) {
        this.balanceBeforeDestination = balanceBeforeDestination;
    }

    public BigDecimal getBalanceAfterDestination() {
        return balanceAfterDestination;
    }

    public void setBalanceAfterDestination(BigDecimal balanceAfterDestination) {
        this.balanceAfterDestination = balanceAfterDestination;
    }
}
