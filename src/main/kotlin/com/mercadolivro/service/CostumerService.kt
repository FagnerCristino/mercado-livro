package com.mercadolivro.service

import com.mercadolivro.model.CostumerModel
import com.mercadolivro.repository.CostumerRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class CostumerService(
    val costumerRepository: CostumerRepository
) {


    fun getAll(name: String?): List<CostumerModel> {

        name?.let {
            return costumerRepository.findByName(name) }
        return costumerRepository.findAll().toList()
    }

    fun createCostumer(costumer: CostumerModel) {
        costumerRepository.save(costumer)
    }

    fun getCustomer(id: Int): CostumerModel {
        return costumerRepository.findById(id).orElseThrow()
    }

    fun update(costumer: CostumerModel)  {
        if (costumerRepository.existsById(costumer.id!!)) {
            throw Exception()

        }
        costumerRepository.save(costumer)
    }

    fun delete(@PathVariable id: Int)  {
        if (costumerRepository.existsById(id)) {
            throw Exception()

        }
        costumerRepository.deleteById(id)
    }
}