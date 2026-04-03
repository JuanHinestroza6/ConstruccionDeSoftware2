package co.edu.tdea.bank.domain.enums;

/**
 * Roles del sistema bancario.
 *
 * <ul>
 *   <li>{@code INDIVIDUAL_CLIENT}   – Cliente persona natural con acceso al portal.</li>
 *   <li>{@code BUSINESS_ADMIN}      – Representante de empresa que gestiona la cuenta corporativa.</li>
 *   <li>{@code TELLER_EMPLOYEE}     – Empleado de ventanilla; ejecuta operaciones presenciales.</li>
 *   <li>{@code COMMERCIAL_EMPLOYEE} – Empleado comercial; vincula clientes y productos.</li>
 *   <li>{@code COMPANY_OPERATOR}    – Operador de empresa; realiza transacciones en nombre de la empresa.</li>
 *   <li>{@code COMPANY_SUPERVISOR}  – Supervisor de empresa; aprueba operaciones de alto valor.</li>
 *   <li>{@code INTERNAL_ANALYST}    – Analista interno; acceso de solo lectura para auditoría y reportes.</li>
 * </ul>
 */
public enum SystemRole {
    INDIVIDUAL_CLIENT,
    BUSINESS_ADMIN,
    TELLER_EMPLOYEE,
    COMMERCIAL_EMPLOYEE,
    COMPANY_OPERATOR,
    COMPANY_SUPERVISOR,
    INTERNAL_ANALYST
}
