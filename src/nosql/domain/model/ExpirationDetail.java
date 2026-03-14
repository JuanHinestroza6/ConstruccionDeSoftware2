package nosql.domain.model;

import java.time.LocalDateTime;

/**
 * <b>DDD Layer:</b> Domain Model (NoSQL)
 * <b>DDD Role:</b> Embedded Value Object (JSON Detail)
 *
 * Contains the variable detail data for an AuditLogEntry
 * of type "Transfer_Expiration".
 * Captures the reason and timing of a transfer expiration event
 * when approval was not granted within the 60-minute window.
 */
public class ExpirationDetail {

    private String reason;
    private LocalDateTime expirationDateTime;
    private int creatorUserID;

    public ExpirationDetail(String reason,
                            LocalDateTime expirationDateTime,
                            int creatorUserID) {
        this.reason = reason;
        this.expirationDateTime = expirationDateTime;
        this.creatorUserID = creatorUserID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getExpirationDateTime() {
        return expirationDateTime;
    }

    public void setExpirationDateTime(LocalDateTime expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
    }

    public int getCreatorUserID() {
        return creatorUserID;
    }

    public void setCreatorUserID(int creatorUserID) {
        this.creatorUserID = creatorUserID;
    }
}
