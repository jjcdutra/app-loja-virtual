package com.jjcdutra.livrovirtual.novoautor

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AutoresController(
    @PersistenceContext
    private val manager: EntityManager,
//    private val proibeEmailDuplicadoAutorValidator: ProibeEmailDuplicadoAutorValidator
) {

//    @InitBinder fun init(binder: WebDataBinder) {binder.addValidators(proibeEmailDuplicadoAutorValidator)}

    @PostMapping("/autores")
    @Transactional
    fun cria(@RequestBody @Valid request: NovoAutorRequest): String {
        val autor = request.toModel()
        manager.persist(autor)
        return autor.toString()
    }
}