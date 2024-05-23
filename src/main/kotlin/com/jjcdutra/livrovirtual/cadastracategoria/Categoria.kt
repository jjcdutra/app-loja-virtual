package com.jjcdutra.livrovirtual.cadastracategoria

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
data class Categoria(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    @field:Column(unique = true)
    val nome: String
) {
    override fun toString(): String {
        return "NovaCategoriaRequest(nome='$nome')"
    }
}