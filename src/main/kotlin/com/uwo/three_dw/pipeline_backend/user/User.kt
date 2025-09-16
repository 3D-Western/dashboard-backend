package com.uwo.three_dw.pipeline_backend.user

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

/**
 * @author Josh Muszka
 * Macros to represent the status of a User of the makerspace
 *
 * Member - standard, default member
 * Admin - special dashboard management permissions; for 3DWestern executives
 * Blacklisted - banned from using the makerspace due to ToS violation
 */
enum class Status {
    Member,
    Admin,
    Blacklisted,
}

/**
 * @author Josh Muszka
 * Macros to represent the Morrissete training-level of a User of the makerspace
 * @see <a href="https://docs.google.com/document/d/1BhJQCVIhRCy1AYST519PUZ_b0Vc8GFs1n7x9s-9-bqk/edit?tab=t.0#heading=h.jaazrxbmfszy">Morissete policy</a>
 */
enum class TrainingLevel {
    BasicAwarenessAndSafety,
    LimitedOperation,
    SupervisorLevel,
    FullyIndependent,
}

/**
 * @author Josh Muszka
 * DB schema for each User record
 *
 * We use student number as the primary key because it is guaranteed to be unique per person + it ties user identities to their account
 * For safety and security purposes, it is important that users be held accountable for the print jobs they submit to the pipeline
 */
@Entity
@Table(name = "users")
data class User(
    @Id val id: Integer, // User's student number
    val email: String, // User's UWO email
    val firstName: String,
    val lastName: String,
    val passwordHash: String,
    val createdDate: Date = Date(),
    val status: Status = Status.Member,
    val trainingLevel: TrainingLevel = TrainingLevel.BasicAwarenessAndSafety,
)