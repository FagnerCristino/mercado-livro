package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.model.enums.CustomerStatus
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class CustomerService(
    val costumerRepository: CustomerRepository,
    val bookService: BookService
) {


    fun getAll(name: String?): List<CustomerModel> {

        name?.let {
            return costumerRepository.findByName(name) }
        return costumerRepository.findAll().toList()
    }

    fun createCostumer(customer: CustomerModel) {
        costumerRepository.save(customer)
    }

    fun findById(id: Int): CustomerModel {
        return costumerRepository.findById(id).orElseThrow()
    }

    fun update(customer: CustomerModel)  {
        if (costumerRepository.existsById(customer.id!!)) {
            throw Exception()

        }
        costumerRepository.save(customer)
    }

    fun delete(@PathVariable id: Int)  {
        val customer = findById(id)
        bookService.deleteByCustomer(customer)
        customer.status = CustomerStatus.INATIVO
        costumerRepository.save(customer)
    }
}