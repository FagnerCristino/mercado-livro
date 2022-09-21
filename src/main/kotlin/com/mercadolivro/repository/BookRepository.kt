package com.mercadolivro.repository

import com.mercadolivro.BookStatus
import com.mercadolivro.model.BookModel
<<<<<<< HEAD
=======
import com.mercadolivro.model.CustomerModel
>>>>>>> f8c2536 (atualizando projeto)
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int>{
    fun findByStatus(status: BookStatus): List<BookModel>
    fun findByCustomer(customer: CustomerModel): List<BookModel>
}