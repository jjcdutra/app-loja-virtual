package com.jjcdutra.livrovirtual.novoautor

import com.jjcdutra.livrovirtual.validation.EmailAvailable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class NovoAutorRequest(
    @field:NotBlank
    val nome: String,

    @field:NotBlank
    @field:Email
    @field:EmailAvailable
    val email: String,

    @field:NotBlank
    @field:Size(max = 400)
    val descricao: String
) {
    fun toModel(): Autor {
        return Autor(
            nome = this.nome,
            email = this.email,
            descricao = this.descricao
        )
    }
}