package com.uwo.three_dw.pipeline_backend.print_job

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

/**
 * @author Josh Muszka
 * Class to handle database/business logic
 */
@Service
class PrintJobService(val repository: PrintJobRepository) {

    /**
     * @author Josh Muszka
     * Retrieve all active print jobs from table
     */
    fun getAll(): List<PrintJob> = repository.findAll()

    /**
     * @author Josh Muszka
     * Retrieve an active print job by ID
     * @param ID
     * @return Print Job or null
     * @throws 404 error if not found
     */
    fun getById(id: Integer): PrintJob = repository.findByIdOrNull(id) ?:
    throw ResponseStatusException(HttpStatus.NOT_FOUND)

    /**
     * @author Josh Muszka
     * Add a new print job to the DB
     * @param PrintJob
     */
    fun create(printJob: PrintJob): PrintJob = repository.save(printJob)

    /**
     * @author Josh Muszka
     * Delete an active Print Job from the database
     * @param ID
     * @throws 404 error if not found
     */
    fun remove(id: Integer) {
        if (repository.existsById(id)) repository.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}