package com.uwo.three_dw.pipeline_backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PipelineBackendApplication

fun main(args: Array<String>) {
    runApplication<PipelineBackendApplication>(*args)
}
