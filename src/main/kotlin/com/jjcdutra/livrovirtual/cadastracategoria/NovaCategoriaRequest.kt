package com.jjcdutra.livrovirtual.cadastracategoria

import com.jjcdutra.livrovirtual.validation.UniqueValue
import jakarta.validation.constraints.NotBlank

data class NovaCategoriaRequest(

    @field:NotBlank
    @field:UniqueValue(domainClass = Categoria::class, fieldName = "nome")
    val nome: String
) {

    fun toModel() = Categoria(nome = this.nome)
}