package com.mercadolivro.repository

import com.mercadolivro.BookStatus
import com.mercadolivro.model.BookModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int>{
    fun findByStatus(status: BookStatus): List<BookModel>
}