package com.uwo.three_dw.pipeline_backend.print_job

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author Josh Muszka
 * ORM interface for our MariaDB instance
 */
@Repository
interface PrintJobRepository : JpaRepository<PrintJob, Integer>