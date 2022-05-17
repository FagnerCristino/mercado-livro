package com.mercadolivro.extension

import com.mercadolivro.controller.request.PostCostumerRequest
import com.mercadolivro.controller.request.PutCostumerRequest
import com.mercadolivro.model.CostumerModel

fun PostCostumerRequest.toCostumerModel(): CostumerModel {
    return CostumerModel(id = null, name = this.name, email = this.email)
}

fun PutCostumerRequest.toCostumerModel(id: Int): CostumerModel {
    return CostumerModel(id = id, name = this.name, email = this.email)
}