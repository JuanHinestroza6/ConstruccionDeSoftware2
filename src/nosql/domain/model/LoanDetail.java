package nosql.domain.model;

import java.math.BigDecimal;

/**
 * <b>DDD Layer:</b> Domain Model (NoSQL)
 * <b>DDD Role:</b> Embedded Value Object (JSON Detail)
 *
 * Contains the variable detail data for an AuditLogEntry of type "Loan_Approval".
 * Captures the approval decision, financial terms, and the analyst
 * responsible for the approval at the moment it occurred.
 */
public class LoanDetail {

    private BigDecimal approvedAmount;
    private BigDecimal interestRate;
    private String previousStatus;
    private String newStatus;
    private int approverAnalystID;

    public LoanDetail(BigDecimal approvedAmount,
                      BigDecimal interestRate,
                      String previousStatus,
                      String newStatus,
                      int approverAnalystID) {
        this.approvedAmount = approvedAmount;
        this.interestRate = interestRate;
        this.previousStatus = previousStatus;
        this.newStatus = newStatus;
        this.approverAnalystID = approverAnalystID;
    }

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(String previousStatus) {
        this.previousStatus = previousStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public int getApproverAnalystID() {
        return approverAnalystID;
    }

    public void setApproverAnalystID(int approverAnalystID) {
        this.approverAnalystID = approverAnalystID;
    }
}
