package com.uwo.three_dw.pipeline_backend.user

import com.uwo.three_dw.pipeline_backend.TrainingLevel
import com.uwo.three_dw.pipeline_backend.UserStatus
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

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
    @Id val studentId: Integer, // User's student number
    val email: String, // User's UWO email
    val firstName: String,
    val lastName: String,
    val passwordHash: String,
    val createdDate: Date = Date(),
    val status: UserStatus = UserStatus.Member,
    val trainingLevel: TrainingLevel = TrainingLevel.BasicAwarenessAndSafety,
)