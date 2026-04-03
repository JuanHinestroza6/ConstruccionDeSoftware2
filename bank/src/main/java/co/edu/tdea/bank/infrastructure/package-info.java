/**
 * Infrastructure layer — adapters that implement the output ports
 * defined in {@code application.port.out}.
 *
 * <p>Sub-packages:
 * <ul>
 *   <li>{@code adapter.sql}   — JPA entities and Spring Data repositories (MySQL)</li>
 *   <li>{@code adapter.mongo} — MongoDB documents and repositories (audit log)</li>
 *   <li>{@code config}        — Spring bean wiring and infrastructure configuration</li>
 * </ul>
 */
package co.edu.tdea.bank.infrastructure;
