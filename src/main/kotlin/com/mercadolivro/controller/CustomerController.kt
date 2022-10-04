package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCostumerRequest
import com.mercadolivro.controller.request.PutCostumerRequest
import com.mercadolivro.controller.response.CustomerResponse
import com.mercadolivro.extension.toCostumerModel
import com.mercadolivro.extension.toResponse
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(
    val customerService : CustomerService
) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerResponse> {
        return customerService.getAll(name).map { it.toResponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCostumer(@RequestBody costumer: PostCostumerRequest) {
        customerService.createCostumer(costumer.toCostumerModel())
    }

    @GetMapping("/{id}")
    fun getCostumerById(@PathVariable id: Int): CustomerResponse {
        return customerService.findById(id).toResponse()

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody costumer: PutCostumerRequest)  {
        val customerSaved = customerService.findById(id)
        customerService.update(costumer.toCostumerModel(customerSaved))

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int)  {
        customerService.delete(id)
    }
}
