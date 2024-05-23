package com.jjcdutra.livrovirtual.cadastracategoria

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoriasController(
    @PersistenceContext
    private val manager: EntityManager,
) {

    @PostMapping("/categorias")
    @Transactional
    fun cria(@RequestBody @Valid request: NovaCategoriaRequest): String {
        val categoria = request.toModel()
        manager.persist(categoria)
        return categoria.toString()
    }
}