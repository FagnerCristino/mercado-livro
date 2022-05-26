package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class CustomerService(
    val costumerRepository: CustomerRepository
) {


    fun getAll(name: String?): List<CustomerModel> {

        name?.let {
            return costumerRepository.findByName(name) }
        return costumerRepository.findAll().toList()
    }

    fun createCostumer(customer: CustomerModel) {
        costumerRepository.save(customer)
    }

    fun getById(id: Int): CustomerModel {
        return costumerRepository.findById(id).orElseThrow()
    }

    fun update(customer: CustomerModel)  {
        if (costumerRepository.existsById(customer.id!!)) {
            throw Exception()

        }
        costumerRepository.save(customer)
    }

    fun delete(@PathVariable id: Int)  {
        if (costumerRepository.existsById(id)) {
            throw Exception()

        }
        costumerRepository.deleteById(id)
    }
}