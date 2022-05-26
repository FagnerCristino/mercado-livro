package com.mercadolivro.extension

import com.mercadolivro.BookStatus
import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.controller.request.PostCostumerRequest
import com.mercadolivro.controller.request.PutCostumerRequest
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel

fun PostCostumerRequest.toCostumerModel(): CustomerModel {
    return CustomerModel(id = null, name = this.name, email = this.email)
}

fun PutCostumerRequest.toCostumerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}