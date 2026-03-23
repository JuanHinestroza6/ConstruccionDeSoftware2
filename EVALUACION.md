# EVALUACIÓN - ContruccionDeSoftware2

## Información General
- Estudiante(s): Juan Francisco Hinestroza Andrade, Miguel Angel Gonzales Mazo
- Rama evaluada: main
- Fecha de evaluación: 2026-03-23

## Tabla de Calificación

| # | Criterio | Peso | Puntaje (1-5) | Nota ponderada |
|---|---|---|---|---|
| 1 | Modelado de dominio | 25% | 3 | 0.75 |
| 2 | Relaciones entre entidades | 15% | 2 | 0.30 |
| 3 | Uso de Enums | 15% | 1 | 0.15 |
| 4 | Manejo de estados | 5% | 1 | 0.05 |
| 5 | Tipos de datos | 5% | 4 | 0.20 |
| 6 | Separación Usuario vs Cliente | 10% | 1 | 0.10 |
| 7 | Bitácora | 5% | 4 | 0.20 |
| 8 | Reglas básicas de negocio | 5% | 2 | 0.10 |
| 9 | Estructura del proyecto | 10% | 2 | 0.20 |
| 10 | Repositorio | 10% | 3 | 0.30 |
| **TOTAL** | | **100%** | | **2.35** |

## Penalizaciones
- Ninguna

## Bonus
- Código limpio con Javadoc y comentarios DDD explicativos: +0.2
- Nombres claros, consistentes y en inglés: +0.1

## Nota Final: 2.7 / 5.0

> Cálculo: 2.35 + 0.2 + 0.1 = 2.65 → 2.7

---

## Análisis por Criterio

### 1. Modelado de dominio (Puntaje: 3)
Entidades identificadas en dos paquetes: `sqlbank.domain.model` (User abstracta, IndividualClient, BusinessClient, BankAccount, Loan, Transfer, BankingProduct) y `nosql.domain.model` (AuditLogEntry, ExpirationDetail, LoanDetail, TransferDetail). La separación SQL/NoSQL es una decisión arquitectónica interesante y coherente con el enunciado. Sin embargo, **`IndividualClient` y `BusinessClient` extienden `User`** — la confusión Usuario=Cliente persiste. No hay una jerarquía de `Cliente` separada.

### 2. Relaciones entre entidades (Puntaje: 2)
Al igual que en el proyecto base (ConstruccionDeSoftwareII), las relaciones se documentan en comentarios de tipo FK (`// FK → User.identificationID`) pero se implementan como `String` ID, no como referencias de objeto. La documentación Javadoc es clara sobre las intenciones, pero el modelo OO no es navegable.

### 3. Uso de Enums (Puntaje: 1)
**⚠️ CRÍTICO:** No existe ningún enum. `systemRole`, `userStatus`, `accountType`, `accountStatus`, `currency`, `loanType`, `loanStatus`, `transferStatus`, `category` — todos como `String`. Esta es la debilidad más grave del proyecto dado su nivel de documentación.

### 4. Manejo de estados (Puntaje: 1)
Las reglas de transición de estado están documentadas en Javadoc (ej. "Under review → Approved or Rejected") pero no implementadas en código. Sin enums ni métodos de transición.

### 5. Tipos de datos (Puntaje: 4)
`BigDecimal` usado correctamente para `currentBalance`, `requestedAmount`, `approvedAmount`, `interestRate`, `amount` ✓. `LocalDate`/`LocalDateTime` para fechas ✓. La precisión financiera está correctamente atendida.

### 6. Separación Usuario vs Cliente (Puntaje: 1)
`IndividualClient extends User` y `BusinessClient extends User`. El README explica correctamente la diferencia conceptual entre usuario del sistema y cliente, pero el código no lo refleja. `User` abstracta sirve como base para todo en lugar de separar access layer de client layer.

### 7. Bitácora (Puntaje: 4)
`AuditLogEntry` en paquete `nosql.domain.model` con `Object detailData` polimórfico ✓. Las clases de detalle `TransferDetail`, `LoanDetail`, `ExpirationDetail` especializan los datos por tipo de operación ✓. El Javadoc documenta la inmutabilidad y el propósito separado del modelo SQL.

### 8. Reglas básicas de negocio (Puntaje: 2)
Reglas de negocio documentadas extensamente en Javadoc (validaciones, flujos de aprobación, restricciones de roles). Sin embargo, ninguna regla está implementada en código. Constructores sin validaciones. La documentación es valiosa pero no compensa la ausencia de código.

### 9. Estructura del proyecto (Puntaje: 2)
No es Maven/Spring Boot. Tiene la separación `sqlbank/` y `nosql/` con subdirectorios `domain/model` en cada uno — coherente con la decisión arquitectónica. Sin embargo no hay sistema de build estándar. El nombre del paquete raíz es correcto (`sqlbank.domain.model`).

### 10. Repositorio (Puntaje: 3)
- **Nombre:** `ContruccionDeSoftware2` — tiene typo (falta "s" en "Contruccion").
- **README:** Excelente documentación — incluye autores, descripción del dominio, tabla de mapeo entidad→clase, explicación de las decisiones arquitectónicas SQL/NoSQL.
- **Commits:** 5 commits con mensajes descriptivos (ADD, Refactor, Enhance README).
- **Ramas:** Solo `main`, sin `develop`.
- **Tag:** Ninguno.

---

## Fortalezas
- README de excelente calidad con documentación de decisiones arquitectónicas.
- Separación SQL/NoSQL bien motivada con bitácora en paquete `nosql`.
- `BigDecimal` y `LocalDateTime` correctamente usados.
- Javadoc extenso que documenta reglas de negocio y decisiones de diseño.
- Commits con mensajes descriptivos.
- Bitácora polimórfica con clases de detalle especializadas.

## Oportunidades de mejora
- **Crítico:** Implementar enums para todos los estados y catálogos. Es la debilidad más grande dado el nivel de documentación.
- **Crítico:** Separar `User` (acceso al sistema) de `Client` (titular de productos). Crear jerarquía `Client → IndividualClient/BusinessClient` independiente.
- Implementar las reglas de negocio documentadas en Javadoc — al menos validaciones básicas en constructores.
- Agregar referencias de objeto entre entidades (ej. `Client client` en lugar de `String applicantClientID`).
- Migrar a Maven/Spring Boot con estructura estándar.
- Corregir typo en nombre del repositorio: "Contruccion" → "Construccion".
- Crear rama `develop` y tag de entrega.
