package com.jjcdutra.livrovirtual.exception

data class ErrorResponse(
    val httpCode: Int,
    val message: String,
    val internalCode: String? = null,
    val errors: List<FieldErrorResponse>? = null
)