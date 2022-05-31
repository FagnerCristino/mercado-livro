package com.mercadolivro.service

import com.mercadolivro.BookStatus
import com.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.model.BookModel
import com.mercadolivro.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun create(book: BookModel) = bookRepository.save(book)

    fun findAll(): List<BookModel> = bookRepository.findAll().toList()

    fun findActives(): List<BookModel> = bookRepository.findByStatus(BookStatus.ATIVO)

    fun findById(id: Int): BookModel = bookRepository.findById(id).orElseThrow()

    fun delete(id: Int) {
        val book = findById(id)
        book.status = BookStatus.CANCELADO
        bookRepository.save(book)
    }

    fun update(book: BookModel) {
        bookRepository.save(book)

    }

}
