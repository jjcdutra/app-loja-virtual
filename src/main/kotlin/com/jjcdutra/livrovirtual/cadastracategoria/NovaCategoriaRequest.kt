package com.jjcdutra.livrovirtual.cadastracategoria

import jakarta.validation.constraints.NotBlank

data class NovaCategoriaRequest(

    @field:NotBlank
    val nome: String
) {

    fun toModel() = Categoria(nome = this.nome)
}