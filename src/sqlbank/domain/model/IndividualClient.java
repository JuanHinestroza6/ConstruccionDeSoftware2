package sqlbank.domain.model;

/**
 * <b>DDD Layer:</b> Domain Model
 * <b>DDD Role:</b> Entity / Aggregate Root
 *
 * Represents a natural person who is a client of the bank.
 * Extends User and specializes it for individual clients.
 *
 * Business rules:
 * - identificationNumber must be unique across all clients.
 * - role is immutable and always "Individual Client".
 * - Can hold BankAccounts and apply for Loans.
 */
public class IndividualClient extends User {

    private String identificationNumber; // Unique
    private final String role = "Individual Client";

    public IndividualClient(int userID,
                            String relatedID,
                            String fullName,
                            String identificationID,
                            String email,
                            String phone,
                            java.time.LocalDate birthDate,
                            String address,
                            String systemRole,
                            String userStatus,
                            String identificationNumber) {
        super(userID, relatedID, fullName, identificationID, email, phone, birthDate, address, systemRole, userStatus);
        this.identificationNumber = identificationNumber;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getRole() {
        return role;
    }
}
