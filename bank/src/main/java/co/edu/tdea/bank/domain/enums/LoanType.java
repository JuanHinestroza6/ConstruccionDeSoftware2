package co.edu.tdea.bank.domain.enums;

/**
 * Catálogo de tipos de préstamo ofrecidos por el banco.
 *
 * <ul>
 *   <li>{@code PERSONAL}   – Crédito de libre inversión para personas naturales.</li>
 *   <li>{@code MORTGAGE}   – Crédito hipotecario con garantía inmueble.</li>
 *   <li>{@code VEHICLE}    – Crédito para adquisición de vehículo.</li>
 *   <li>{@code COMMERCIAL} – Crédito empresarial para capital de trabajo o inversión.</li>
 *   <li>{@code MICROCREDIT}– Microcrédito para pequeños emprendedores.</li>
 * </ul>
 */
public enum LoanType {
    PERSONAL,
    MORTGAGE,
    VEHICLE,
    COMMERCIAL,
    MICROCREDIT
}
