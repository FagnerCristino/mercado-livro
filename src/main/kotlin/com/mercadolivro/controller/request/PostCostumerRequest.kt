package com.mercadolivro.controller.request

import com.mercadolivro.extension.toCostumerModel
import com.mercadolivro.model.CostumerModel

data class PostCostumerRequest (

    var name: String,
    var email: String,

)

