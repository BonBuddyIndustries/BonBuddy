package com.example.bonbuddy.models.product

import java.util.UUID

data class SLProduct(
    override val id: UUID = UUID.randomUUID(),
    val productID: UUID,
    override var title: String,
    override var quantity: Int = 0,
    override var unit: ProductUnit,
    override var category: ProductCategory = ProductCategory.OTHER,
    var price: Double? = null,
    var isChecked: Boolean = false
) : BaseProduct()
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

        if (other !is SLProduct)
        {
            return false
        }

        return productID == other.productID
    }
}