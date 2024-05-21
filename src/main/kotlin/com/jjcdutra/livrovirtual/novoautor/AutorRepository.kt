package com.jjcdutra.livrovirtual.novoautor

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AutorRepository : JpaRepository<Autor, Long> {
    fun findByEmail(email: String): Optional<Autor>

    fun existsByEmail(value: String): Boolean
}