package com.uwo.three_dw.pipeline_backend.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author Josh Muszka
 * ORM interface for our MariaDB instance
 */
@Repository
interface UserRepository : JpaRepository<User, Integer>