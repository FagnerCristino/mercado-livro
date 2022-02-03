package com.mercadolivro.service

import com.mercadolivro.controller.request.PostCostumerRequest
import com.mercadolivro.controller.request.PutCostumerRequest
import com.mercadolivro.model.CostumerModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class CostumerService {

    val costumers = mutableListOf<CostumerModel>()

    fun getAll(name: String?): List<CostumerModel> {
        name?.let {
            return costumers.filter { it.name.contains(name, true) }
        }
        return costumers
    }

    fun createCostumer(costumer: PostCostumerRequest) {
        var id = if (costumers.isEmpty()) {
            "1"
        } else {
            costumers.last().id.toInt() + 1
        }.toString()

        costumers.add(CostumerModel(id, costumer.name, costumer.email))
    }

    fun getCostumerByName(id: String): CostumerModel {
        return costumers.filter { it.id == id }.first()
    }

    fun update(id: String, costumer: PutCostumerRequest)  {
        costumers.filter { it.id == id }.first().let {
            it.name = costumer.name
            it.email = costumer.email
        }
    }

    fun delete(@PathVariable id: String)  {
        costumers.removeIf{
            it.id == id
        }
    }
}