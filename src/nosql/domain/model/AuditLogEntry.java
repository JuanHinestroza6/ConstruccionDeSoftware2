package nosql.domain.model;

import java.time.LocalDateTime;

/**
 * <b>DDD Layer:</b> Domain Model (NoSQL)
 * <b>DDD Role:</b> Domain Event / Audit Document
 *
 * Represents an immutable audit record stored in a NoSQL document collection.
 * Captures every significant operation performed in the banking system
 * for traceability, compliance, and auditing purposes (ISO 27001).
 *
 * Business rules:
 * - logID is unique and acts as the document _id in the NoSQL collection.
 * - Records are immutable — once written, they must never be modified.
 * - detailData is polymorphic: holds exactly one of TransferDetail,
 *   LoanDetail, or ExpirationDetail depending on operationType.
 * - This collection is NOT used to calculate account balances —
 *   balances are managed exclusively in the SQL relational database.
 */
public class AuditLogEntry {

    private String logID; // Unique
    private String operationType;
    private LocalDateTime operationDateTime;
    private int userID;
    private String userRole;
    private String affectedProductID;
    private Object detailData;

    public AuditLogEntry(String logID,
                         String operationType,
                         LocalDateTime operationDateTime,
                         int userID,
                         String userRole,
                         String affectedProductID,
                         Object detailData) {
        this.logID = logID;
        this.operationType = operationType;
        this.operationDateTime = operationDateTime;
        this.userID = userID;
        this.userRole = userRole;
        this.affectedProductID = affectedProductID;
        this.detailData = detailData;
    }

    public String getLogID() {
        return logID;
    }

    public void setLogID(String logID) {
        this.logID = logID;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public LocalDateTime getOperationDateTime() {
        return operationDateTime;
    }

    public void setOperationDateTime(LocalDateTime operationDateTime) {
        this.operationDateTime = operationDateTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getAffectedProductID() {
        return affectedProductID;
    }

    public void setAffectedProductID(String affectedProductID) {
        this.affectedProductID = affectedProductID;
    }

    public Object getDetailData() {
        return detailData;
    }

    public void setDetailData(Object detailData) {
        this.detailData = detailData;
    }
}
