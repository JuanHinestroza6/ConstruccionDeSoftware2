package sqlbank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * <b>DDD Layer:</b> Domain Model
 * <b>DDD Role:</b> Entity
 *
 * Represents a bank account owned by a client (individual or business).
 * Central entity for all financial operations — transfers are executed
 * against accounts and loan disbursements are credited to accounts.
 *
 * Business rules:
 * - accountNumber must be unique.
 * - No operations allowed when accountStatus is "Blocked" or "Cancelled".
 * - currentBalance must never be modified directly — only through
 *   Transfer execution or Loan disbursement flows.
 * - currency must be one of: USD | COP | EUR.
 */
public class BankAccount {

    private String accountNumber; // PK
    private String accountType;
    private String holderID; // FK → User.identificationID
    private BigDecimal currentBalance;
    private String currency;
    private String accountStatus;
    private LocalDate openingDate;

    public BankAccount(String accountNumber,
                       String accountType,
                       String holderID,
                       BigDecimal currentBalance,
                       String currency,
                       String accountStatus,
                       LocalDate openingDate) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.holderID = holderID;
        this.currentBalance = currentBalance;
        this.currency = currency;
        this.accountStatus = accountStatus;
        this.openingDate = openingDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getHolderID() {
        return holderID;
    }

    public void setHolderID(String holderID) {
        this.holderID = holderID;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }
}
