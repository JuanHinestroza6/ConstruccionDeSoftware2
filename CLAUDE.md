# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run Commands

All Maven commands must be run from the `/bank` subdirectory:

```bash
cd bank

# Build
./mvnw clean install

# Run tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=BankApplicationTests

# Run the application
./mvnw spring-boot:run

# Build without tests
./mvnw clean install -DskipTests
```

Stack: Spring Boot 4.0.5, Java 26, Maven 3.9.14 (via wrapper).

## Repository Structure

There are **two distinct source trees** that serve different purposes:

```
/src/                              # Pure domain model — evaluated as academic deliverable
  sqlbank/domain/model/            # Relational entities (User, Account, Loan, Transfer, BankingProduct)
  nosql/domain/model/              # Audit log documents (AuditLogEntry + detail embedded objects)

/bank/                             # Spring Boot application — skeleton awaiting implementation
  src/main/java/co/edu/tdea/bank/
    domain/                        # Intended for entities and domain services
    application/                   # Intended for use cases, input/output ports
    infrastructure/                # Intended for REST controllers and persistence adapters
    shared/                        # Intended for exceptions and shared utilities
```

The `/src` tree is the baseline domain model; the `/bank` tree is the Spring Boot skeleton where the full hexagonal architecture will be implemented.

## Architecture

The project follows **Hexagonal Architecture (Ports & Adapters)** with **Domain-Driven Design** layering:

- **Domain layer** (`domain/model`, `domain/service`): entities, aggregates, value objects, domain services
- **Application layer** (`application/usecase`, `application/port/in`, `application/port/out`): use cases and port interfaces
- **Infrastructure layer** (`infrastructure/adapter/in/web`, `infrastructure/adapter/out/persistence`, `infrastructure/adapter/out/audit`): REST controllers, JPA repositories, audit adapters

**Polyglot persistence** is intentional:
- SQL (relational) — transactional data: Users, Clients, Accounts, Loans, Transfers
- NoSQL (document) — immutable audit log: `AuditLogEntry` with polymorphic detail objects (`TransferDetail`, `LoanDetail`, `ExpirationDetail`)

## Domain Model Key Decisions

- `User` is an abstract aggregate root. `IndividualClient` and `BusinessClient` extend it — this is a known design issue where the User (system access) and Client (banking client) roles are conflated.
- All monetary amounts use `BigDecimal`; dates use `LocalDate`/`LocalDateTime`.
- Status and role fields (e.g., `accountStatus`, `loanStatus`, `systemRole`) are currently plain `String` — these should be migrated to enums.
- Business rules are documented in Javadoc but not yet enforced in constructors or service methods.
- Foreign key relationships between entities are stored as `String` IDs rather than object references.

## Current Implementation Status

- Domain model classes in `/src`: complete with Javadoc
- Spring Boot `/bank` module: directory skeleton only — all `domain/`, `application/`, and `infrastructure/` packages are empty
- No JPA configuration, no database drivers added to `pom.xml`
- No REST controllers, repositories, or service implementations exist yet
- Tests: only a single context-load smoke test (`BankApplicationTests`)
