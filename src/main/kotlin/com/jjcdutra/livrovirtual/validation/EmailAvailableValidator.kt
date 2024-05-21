package com.jjcdutra.livrovirtual.validation

import com.jjcdutra.livrovirtual.novoautor.AutorRepository
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class EmailAvailableValidator(
    private val autorRepository: AutorRepository
) : ConstraintValidator<EmailAvailable, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrEmpty()) return false

        return !autorRepository.existsByEmail(value)
    }
}