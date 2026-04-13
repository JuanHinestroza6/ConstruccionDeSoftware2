package co.edu.tdea.bank.domain.enums;

/**
 * Estado del usuario en el sistema.
 *
 * <ul>
 *   <li>{@code ACTIVE}   – Puede autenticarse y operar con normalidad.</li>
 *   <li>{@code INACTIVE} – Cuenta deshabilitada administrativamente; no puede operar.</li>
 *   <li>{@code BLOCKED}  – Bloqueado por intentos fallidos u otra restricción de seguridad.</li>
 * </ul>
 */
public enum UserStatus {
    ACTIVE,
    INACTIVE,
    BLOCKED
}
