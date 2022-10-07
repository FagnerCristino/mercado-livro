package com.mercadolivro.controller.request

import com.mercadolivro.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PutCostumerRequest (

    @field:NotEmpty(message = "Nome é obrigatório")
    var name: String,
    @field:Email(message = "E-mail inválido")
    @EmailAvailable(message = "E-mail já em uso")
    var email: String,

)