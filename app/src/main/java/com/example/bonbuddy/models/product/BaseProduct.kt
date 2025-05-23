package com.example.bonbuddy.models.product

import java.util.UUID

abstract class BaseProduct
{
    abstract val id: UUID
    abstract var title: String
    abstract var quantity: Int
    abstract var unit: ProductUnit
    abstract var category: ProductCategory
}