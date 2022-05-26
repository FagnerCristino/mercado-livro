package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCostumerRequest
import com.mercadolivro.controller.request.PutCostumerRequest
import com.mercadolivro.extension.toCostumerModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("costumer")
class CustomerController(
    val customerService : CustomerService
) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAll(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCostumer(@RequestBody costumer: PostCostumerRequest) {
        customerService.createCostumer(costumer.toCostumerModel())
    }

    @GetMapping("/{id}")
    fun getCostumerById(@PathVariable id: Int): CustomerModel {
        return customerService.getById(id)

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody costumer: PutCostumerRequest)  {
        customerService.update(costumer.toCostumerModel(id))

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int)  {
        customerService.delete(id)
    }
}
