package com.mercadolivro.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCostumerRequest (

    @field:NotEmpty(message = "Nome é obrigatório")
    var name: String,
    @field:Email(message = "E-mail deve ser válido")
    var email: String,
    @field:NotEmpty(message = "Senha deve ser informada")
    var password: String

)

