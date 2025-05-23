package com.example.bonbuddy.models.retailer

import java.util.UUID

data class Retailer(
    val id: UUID = UUID.randomUUID(),
    var name: String,
)