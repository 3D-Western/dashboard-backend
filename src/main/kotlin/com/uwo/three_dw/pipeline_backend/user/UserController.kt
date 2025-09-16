package com.uwo.three_dw.pipeline_backend.user

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * @author Josh Muszka
 * Endpoints relating to the Users table
 */
@RequestMapping("api/v0/users")
@RestController
class UserController(val service: UserService) {

    /**
     * @author Josh Muszka
     * Retrieve all users
     * @return array of User objects
     */
    @GetMapping("/all")
    fun getAllUsers() = service.getAll()

    /**
     * @author Josh Muszka
     * Retrieve a single user via ID / student number
     * @param ID / student number
     * @returns User object
     */
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Integer) = service.getById(id)

    /**
     * @author Josh Muszka
     * Create a new User to store in the DB
     * @param User object (as JSON)
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveUser(@RequestBody user: User): User = service.create(user)

    /**
     * @author Josh Muszka
     * Delete a User by ID / student number
     * @param ID / student number
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: Integer) = service.remove(id)
}