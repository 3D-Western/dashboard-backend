package com.uwo.three_dw.pipeline_backend.print_job

import com.uwo.three_dw.pipeline_backend.PrintStatus
import com.uwo.three_dw.pipeline_backend.completed_order.CompletedOrder
import com.uwo.three_dw.pipeline_backend.user.User
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.util.Date
import java.util.UUID

/**
 * @author Josh Muszka
 * DB schema for each active Print Job record
 *
 * Each print job is associated with a single user - this is a n:1 relationship
 * The user's student number is used as a foreign key
 *
 * Each print job is associated with a form data record (1:1) that the user submitted upon uploading the model file - this is a foriegn key
 *
 * Some print jobs may be reprints of past (failed) print jobs. If so, there is a foreign key to the original print job; if not, this foreign key is null
 */
@Entity
@Table(name = "print_jobs")
data class PrintJob(
    @Id @GeneratedValue(strategy = GenerationType.UUID) var id: UUID,
    @ManyToOne @JoinColumn(name = "student_id") val user: User,
    val filepath: String, // where the STL file is located in storage
    val orderPlaced: Date = Date(),
    val status: PrintStatus = PrintStatus.InQueue,
    val description: String,
    val name: String,
    // TODO: foreign key to form data entry
    @OneToOne (cascade = [CascadeType.ALL]) val reprint: CompletedOrder? = null,
)