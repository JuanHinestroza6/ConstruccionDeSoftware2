package co.edu.tdea.bank.domain.enums;

/**
 * Estados del ciclo de vida de una transferencia, según el enunciado del banco.
 *
 * <p>Flujo permitido:
 * <pre>
 *   PENDING_APPROVAL ──► EXECUTED
 *          │
 *          ├──────────── REJECTED
 *          │
 *          └──────────── EXPIRED
 * </pre>
 */
public enum TransferStatus {
    PENDING_APPROVAL,
    EXECUTED,
    REJECTED,
    EXPIRED
}
