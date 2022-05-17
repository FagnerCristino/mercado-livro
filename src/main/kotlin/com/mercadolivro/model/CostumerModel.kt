package com.mercadolivro.model

import javax.persistence.*

@Entity(name = "customer")
data class CostumerModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,
    @Column
    var email: String

)