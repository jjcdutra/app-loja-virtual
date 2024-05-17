package com.jjcdutra.livrovirtual.novoautor

import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator
import java.util.*

@Component
class ProibeEmailDuplicadoAutorValidator(
    private val autorRepository: AutorRepository
) : Validator {
    override fun supports(clazz: Class<*>): Boolean {
        return NovoAutorRequest::class.java.isAssignableFrom(clazz)
    }

    override fun validate(target: Any, errors: Errors) {
        if (errors.hasErrors()) return

        val request: NovoAutorRequest = target as NovoAutorRequest
        val possivelAutor: Optional<Autor> = autorRepository.findByEmail(request.email)
        if (possivelAutor.isPresent) {
            errors.rejectValue("email", "email", "E-mail já cadastrado para outro autor")
        }
    }
}