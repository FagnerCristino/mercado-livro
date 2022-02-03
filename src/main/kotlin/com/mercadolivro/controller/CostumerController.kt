package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCostumerRequest
import com.mercadolivro.controller.request.PutCostumerRequest
import com.mercadolivro.model.CostumerModel
import com.mercadolivro.service.CostumerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("costumer")
class CostumerController(
    val costumerService : CostumerService
) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CostumerModel> {
        return costumerService.getAll(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCostumer(@RequestBody costumer: PostCostumerRequest) {
        costumerService.createCostumer(costumer)
    }

    @GetMapping("/{id}")
    fun getCostumerById(@PathVariable id: String): CostumerModel {
        return costumerService.getCostumerByName(id)

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody costumer: PutCostumerRequest)  {
        costumerService.update(id, costumer)

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String)  {
        costumerService.delete(id)
    }
}
