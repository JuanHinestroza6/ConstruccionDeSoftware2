package co.edu.tdea.bank.domain.enums;

/**
 * Estado operativo de una cuenta bancaria.
 *
 * <ul>
 *   <li>{@code ACTIVE}   – Cuenta operativa; acepta depósitos y retiros.</li>
 *   <li>{@code INACTIVE} – Cuenta sin movimientos recientes; no acepta operaciones.</li>
 *   <li>{@code BLOCKED}  – Bloqueada administrativamente o por seguridad; conserva saldo.</li>
 *   <li>{@code CANCELED} – Cancelada definitivamente; no admite ninguna operación.</li>
 * </ul>
 */
public enum AccountStatus {
    ACTIVE,
    INACTIVE,
    BLOCKED,
    CANCELED
}
