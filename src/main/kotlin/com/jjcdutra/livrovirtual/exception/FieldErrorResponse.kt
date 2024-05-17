package com.jjcdutra.livrovirtual.exception

data class FieldErrorResponse(
    val field: String,
    val message: String
)