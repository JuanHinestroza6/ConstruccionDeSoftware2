package sqlbank.domain.model;

/**
 * <b>DDD Layer:</b> Domain Model
 * <b>DDD Role:</b> Value Object / Catalog Entity
 *
 * Represents a catalog entry defining the types of products and services
 * offered by the bank. Acts as a reference table for account types and
 * loan categories.
 *
 * Business rules:
 * - productCode must be unique.
 * - category must be one of: Accounts | Loans | Services.
 * - requiresApproval determines whether creating this product triggers
 *   an approval workflow.
 */
public class BankingProduct {

    private String productCode; // PK
    private String productName;
    private String category;
    private boolean requiresApproval;

    public BankingProduct(String productCode,
                          String productName,
                          String category,
                          boolean requiresApproval) {
        this.productCode = productCode;
        this.productName = productName;
        this.category = category;
        this.requiresApproval = requiresApproval;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isRequiresApproval() {
        return requiresApproval;
    }

    public void setRequiresApproval(boolean requiresApproval) {
        this.requiresApproval = requiresApproval;
    }
}
