package com.example.bonbuddy.models.product

import java.util.UUID

data class Product(
    val id: UUID = UUID.randomUUID(),
    var title: String,
    var quantity: Int = 0,
    var unit: ProductUnit,
    var category: ProductCategory = ProductCategory.OTHER,
    var isFavorite: Boolean = false,
    var price: Double? = null
)
{
    override fun hashCode(): Int
    {
        return id.hashCode()
    }

    override fun equals(other: Any?): Boolean
    {
        // reference check
        if (this === other)
        {
            return true
        }

        if (other !is Product)
        {
            return false
        }

        return id == other.id
    }
}