# EVALUACION 2 - ContruccionDeSoftware2

## Informacion general
- Estudiante(s): Juan Francisco Hinestroza Andrade, Miguel Angel Gonzales Mazo
- Rama evaluada: develop
- Commit evaluado: acc55f396aba50d570990520d7bd9c556eda3d29
- Fecha: 2026-04-11
- Nota: Proyecto Spring Boot con arquitectura hexagonal. Dominio en `bank/src/main/java/co/edu/tdea/bank/domain/`. Puertos de salida en capa `application/port/out/`. Implementacion de alto nivel con dominio rico y documentacion Javadoc.

---

## Tabla de calificacion

| # | Criterio | Peso | Puntaje (1-5) | Contribucion |
|---|----------|------|---------------|--------------|
| 1 | Modelado de dominio | 20% | 5 | 1.00 |
| 2 | Modelado de puertos | 20% | 4 | 0.80 |
| 3 | Modelado de servicios de dominio | 20% | 3 | 0.60 |
| 4 | Enums y estados | 10% | 5 | 0.50 |
| 5 | Reglas de negocio criticas | 10% | 5 | 0.50 |
| 6 | Bitacora y trazabilidad | 5% | 4 | 0.20 |
| 7 | Estructura interna de dominio | 10% | 4 | 0.40 |
| 8 | Calidad tecnica base en domain | 5% | 5 | 0.25 |
| | **Total base** | **100%** | | **4.25** |

**Formula:** Nota = sum(puntaje_i × peso_i) / 100

---

## Penalizaciones
Ninguna.

---

## Bonus

| Bonus | Valor | Justificacion |
|---|---|---|
| Excelente trazabilidad en bitacora | +0.1 | `RegisterAuditLogUseCase` y `AuditLogPort`. `ExpirePendingTransfersUseCase` para la regla de 60 minutos. |
| **Total bonus** | **+0.1** | |

**Nota base:** 4.25
**Bonus:** +0.10
**Nota final:** 4.35

---

## Nota final
**4.35 / 5.0**

---

## Hallazgos

### Fortalezas
- **Javadoc en entidades de dominio:** `BankAccount` documenta explicitamente sus invariantes: balance nunca negativo, montos positivos, cuentas bloqueadas no operable. Excelente practica de legibilidad.
- **9 enums completos:** `AccountStatus`, `AccountType`, `CurrencyType`, `LoanStatus`, `LoanType`, `ProductCategory`, `SystemRole`, `TransferStatus`, `UserStatus`.
- **Modelo de dominio con factory methods y validaciones:** `BankAccount.open()` valida todos los invariantes antes de construir. `Loan.request()` con `Objects.requireNonNull` y validaciones de negocio.
- **10 puertos de entrada atomicos:** Un puerto por caso de uso, todos bien nombrados con semantica de negocio.
- **7 puertos de salida con firmas semanticas:** `findByClientId`, `findByStatus`, `findPendingOlderThan` en `TransferRepositoryPort` (cubriendo la regla de 60 min).
- **`ExpirePendingTransfersUseCase`** implementa la regla de vencimiento de transferencias de alto monto.
- **Código en ingles**, `BigDecimal`, `LocalDate`, `UUID` correctamente utilizados.

### Debilidades
- **Puertos en application, no domain:** Igual que ConstruccionDeSoftwareII, los puertos de salida estan en `application/port/out/` en lugar de `domain/`. Arquitectura hexagonal con ligera desviacion en capas.
- **Sin servicios de dominio en capa domain:** La logica de orquestacion vive en `application/usecase`. El dominio es rico en comportamiento de entidades pero carece de servicios de dominio explícitos.
- **Infraestructura skeleton:** Solo `package-info.java` en infraestructura — sin adaptadores implementados.

### Observacion de similitud de codigo
La estructura de dominio de este repositorio es practicamente identica a la de `ConstruccionDeSoftwareII` (Maria Jose Lopez Velasquez / Juan Diego Millan Cano), diferenciandose solo en el nombre del paquete (`co.edu.tdea.bank` vs `app`) y en la presencia de Javadoc mas completo en este repositorio.

Este repositorio parece ser el original con mas documentacion. Se recomienda al docente investigar si hubo colaboracion o copia entre ambos grupos.

---

## Recomendaciones
1. Mover puertos de salida a la capa `domain/` para arquitectura hexagonal estricta.
2. Implementar al menos un adaptador de persistencia para validar el funcionamiento de los puertos.
3. Mantener la practica de Javadoc en invariantes de negocio — es un diferencial positivo.
