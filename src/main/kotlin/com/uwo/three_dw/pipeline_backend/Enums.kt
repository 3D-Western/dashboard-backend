package com.uwo.three_dw.pipeline_backend

/**
 * @author Josh Muszka
 * Macros to represent the current status of an ongoing print job
 *
 * InQueue: awaiting to be printed
 * Printing: actively being printed
 * Ready: finished printing and ready for pickup
 * Flagged: model-detection pipeline flagged the print request for manual review
 * Error: something went wrong during the printing process
 */
enum class PrintStatus {
    InQueue,
    Printing,
    Ready,
    Flagged,
    Error,
}

/**
 * @author Josh Muszka
 * Macros to represent the result of a completed order / past print job
 *
 * Success: model was successfully printed to quality standards
 * Fail: something went wrong during slicing or printing that caused a subpar result
 */
enum class OrderStatus {
    Success,
    Fail,
}

/**
 * @author Josh Muszka
 * Macros to represent the status of a User of the makerspace
 *
 * Member - standard, default member
 * Admin - special dashboard management permissions; for 3DWestern executives
 * Blacklisted - banned from using the makerspace due to ToS violation
 */
enum class UserStatus {
    Member,
    Admin,
    Blacklisted,
}

/**
 * @author Josh Muszka
 * Macros to represent the Morrissete training-level of a User of the makerspace
 * @see <a href="https://docs.google.com/document/d/1BhJQCVIhRCy1AYST519PUZ_b0Vc8GFs1n7x9s-9-bqk/edit?tab=t.0#heading=h.jaazrxbmfszy">Morrissette policy</a>
 */
enum class TrainingLevel {
    BasicAwarenessAndSafety,
    LimitedOperation,
    SupervisorLevel,
    FullyIndependent,
}