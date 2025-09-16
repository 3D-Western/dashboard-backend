package com.uwo.three_dw.pipeline_backend.user

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

/**
 * @author Josh Muszka
 * Class to handle database/business logic
 */
@Service
class UserService(val repository: UserRepository) {

    /**
     * @author Josh Muszka
     * Retrieve all Users from table
     */
    fun getAll(): List<User> = repository.findAll()

    /**
     * @author Josh Muszka
     * Retrieve a User by ID
     * @param ID
     * @return User or null
     * @throws 404 error if not found
     */
    fun getById(id: Integer): User = repository.findByIdOrNull(id) ?:
    throw ResponseStatusException(HttpStatus.NOT_FOUND)

    /**
     * @author Josh Muszka
     * Add a new user to the DB
     * @param User
     */
    fun create(user: User): User = repository.save(user)

    /**
     * @author Josh Muszka
     * Delete a user from the database
     * @param ID
     * @throws 404 error if not found
     */
    fun remove(id: Integer) {
        if (repository.existsById(id)) repository.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}