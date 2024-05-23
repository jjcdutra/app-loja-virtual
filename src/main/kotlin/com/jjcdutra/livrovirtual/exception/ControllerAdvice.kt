package com.jjcdutra.livrovirtual.exception

import org.postgresql.util.PSQLException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        exception: MethodArgumentNotValidException
    ): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            httpCode = HttpStatus.UNPROCESSABLE_ENTITY.value(),
            message = "Invalid request",
            errors = exception.bindingResult.fieldErrors.map {
                FieldErrorResponse(
                    field = it.field,
                    message = it.defaultMessage ?: "invalid"
                )
            }
        )
        return ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY)
    }

    @ExceptionHandler(PSQLException::class)
    fun handlePSQLException(exception: PSQLException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            httpCode = HttpStatus.BAD_REQUEST.value(),
            message = "Valor já cadastrado no banco de dados"
        )

        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }
}