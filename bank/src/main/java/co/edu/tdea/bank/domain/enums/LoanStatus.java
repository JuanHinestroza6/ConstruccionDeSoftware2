package co.edu.tdea.bank.domain.enums;

/**
 * Estados del ciclo de vida de un préstamo, según el enunciado del banco.
 *
 * <p>Flujo permitido:
 * {@code UNDER_REVIEW} → {@code APPROVED} | {@code REJECTED}
 * {@code APPROVED}     → {@code DISBURSED}
 * </p>
 */
public enum LoanStatus {
    UNDER_REVIEW,
    APPROVED,
    REJECTED,
    DISBURSED
}
