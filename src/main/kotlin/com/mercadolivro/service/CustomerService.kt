package com.mercadolivro.service

import com.mercadolivro.exception.NotFoundException
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.model.enums.CustomerStatus
import com.mercadolivro.model.enums.Errors
import com.mercadolivro.model.enums.Role
import com.mercadolivro.repository.CustomerRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val bookService: BookService,
    private val bCrypt: BCryptPasswordEncoder
) {


    fun getAll(name: String?): List<CustomerModel> {

        name?.let {
            return customerRepository.findByName(name) }
        return customerRepository.findAll().toList()
    }

    fun createCostumer(customer: CustomerModel) {
       val customerCopy =  customer.copy(
            roles = setOf(Role.CUSTOMER),
           password = bCrypt.encode(customer.password)
        )
        customerRepository.save(customerCopy)
    }

    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow{ NotFoundException(Errors.ML201.message.format(id), Errors.ML201.code) }
    }

    fun update(customer: CustomerModel)  {
        if (customerRepository.existsById(customer.id!!)) {
            throw Exception()

        }
        customerRepository.save(customer)
    }

    fun delete(@PathVariable id: Int)  {
        val customer = findById(id)
        bookService.deleteByCustomer(customer)
        customer.status = CustomerStatus.INATIVO
        customerRepository.save(customer)
    }

    fun emailAvailable(email: String): Boolean {
        return !customerRepository.existsByEmail(email)

    }
}