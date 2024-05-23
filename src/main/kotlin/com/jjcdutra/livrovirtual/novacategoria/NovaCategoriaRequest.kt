package com.jjcdutra.livrovirtual.novacategoria

import jakarta.validation.constraints.NotBlank

data class NovaCategoriaRequest(

    @field:NotBlank
    val nome: String
) {

    fun toModel() = Categoria(nome = this.nome)
}