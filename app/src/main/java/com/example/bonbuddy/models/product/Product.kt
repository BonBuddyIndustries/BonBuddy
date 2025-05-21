package com.example.bonbuddy.models.product

import java.util.UUID

data class Product(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    var quantity: Int = 0,
    val unit: ProductUnit,
    val category: ProductCategory = ProductCategory.OTHER,
    val isFavorite: Boolean = false,
    val price: Double? = null
)
{
    override fun hashCode(): Int
    {
        return id.hashCode()
    }

    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        return id == other.id
    }
}