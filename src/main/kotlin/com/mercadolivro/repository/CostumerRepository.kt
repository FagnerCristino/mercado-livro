package com.mercadolivro.repository

import com.mercadolivro.model.CostumerModel
import org.springframework.data.repository.CrudRepository

interface CostumerRepository : CrudRepository<CostumerModel, Int>{

    fun findByName(name: String): List<CostumerModel>
}