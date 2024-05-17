package com.jjcdutra.livrovirtual.novoautor

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

@Entity
data class Autor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    val nome: String,

    @field:NotBlank
    @field:Email
    val email: String,

    @field:NotBlank
    @field:Size(max = 400)
    val descricao: String,

    val instanteCriacao: LocalDateTime = LocalDateTime.now()
) {
    override fun toString(): String {
        return "Autor(id=$id, nome='$nome', email='$email', descricao='$descricao', instanteCriacao=$instanteCriacao)"
    }
}