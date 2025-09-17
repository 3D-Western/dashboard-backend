package com.uwo.three_dw.pipeline_backend.completed_order

import com.uwo.three_dw.pipeline_backend.OrderStatus
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
 * DB schema for each Completed Order record
 *
 * Each print job is associated with a single user - this is a n:1 relationship
 * The user's student number is used as a foreign key
 *
 * Each print job is associated with a form data record (1:1) that the user submitted upon uploading the model file - this is a foriegn key
 *
 * Some print jobs may be reprints of past (failed) print jobs. If so, there is a foreign key to the original print job; if not, this foreign key is null
 */
@Entity
@Table(name = "completed_orders")
data class CompletedOrder (
    @Id @GeneratedValue(strategy = GenerationType.UUID) var id: UUID,
    @ManyToOne @JoinColumn(name = "student_id") val user: User,
    val orderPlaced: Date,
    val orderFinished: Date = Date(),
    val status: OrderStatus = OrderStatus.Success,
    val description: String,
    val name: String,
    // TODO: foreign key to form data entry
    @OneToOne (cascade = [CascadeType.ALL]) val reprint: CompletedOrder? = null,
)