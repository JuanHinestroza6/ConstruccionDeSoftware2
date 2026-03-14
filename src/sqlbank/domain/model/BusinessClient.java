package sqlbank.domain.model;

/**
 * <b>DDD Layer:</b> Domain Model
 * <b>DDD Role:</b> Entity / Aggregate Root
 *
 * Represents a legal entity (company) that is a client of the bank.
 * Extends User and specializes it for corporate clients.
 *
 * Business rules:
 * - taxID (NIT) must be unique across all clients.
 * - role is immutable and always "Business Client".
 * - birthDate is null (not applicable for companies).
 * - legalRepresentative references an IndividualClient.identificationNumber.
 * - Can hold BankAccounts and apply for Loans.
 * - High-value transfers require approval from a Business Supervisor.
 */
public class BusinessClient extends User {

    private String companyName;
    private String taxID; // Unique
    private String legalRepresentative; // FK → IndividualClient.identificationNumber
    private final String role = "Business Client";

    public BusinessClient(int userID,
                          String relatedID,
                          String fullName,
                          String identificationID,
                          String email,
                          String phone,
                          String address,
                          String systemRole,
                          String userStatus,
                          String companyName,
                          String taxID,
                          String legalRepresentative) {
        super(userID, relatedID, fullName, identificationID, email, phone, null, address, systemRole, userStatus);
        this.companyName = companyName;
        this.taxID = taxID;
        this.legalRepresentative = legalRepresentative;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getRole() {
        return role;
    }
}
