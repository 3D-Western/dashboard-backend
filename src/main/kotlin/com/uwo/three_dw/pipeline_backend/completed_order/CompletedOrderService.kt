package com.uwo.three_dw.pipeline_backend.completed_order

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

/**
 * @author Josh Muszka
 * Class to handle database/business logic
 */
@Service
class CompletedOrderService(val repository: CompletedOrderRepository) {

    /**
     * @author Josh Muszka
     * Retrieve all past print jobs from table
     */
    fun getAll(): List<CompletedOrder> = repository.findAll()

    /**
     * @author Josh Muszka
     * Retrieve a Completed Order by ID
     * @param ID
     * @return Completed Order or null
     * @throws 404 error if not found
     */
    fun getById(id: Integer): CompletedOrder = repository.findByIdOrNull(id) ?:
    throw ResponseStatusException(HttpStatus.NOT_FOUND)

    /**
     * @author Josh Muszka
     * Add a new completed order to the DB
     * @param CompletedOrder
     */
    fun create(completedOrder: CompletedOrder): CompletedOrder = repository.save(completedOrder)

    /**
     * @author Josh Muszka
     * Delete a completed order from the database
     * @param ID
     * @throws 404 error if not found
     */
    fun remove(id: Integer) {
        if (repository.existsById(id)) repository.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}