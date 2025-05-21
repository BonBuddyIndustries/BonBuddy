package com.example.bonbuddy.repos.cart

import com.example.bonbuddy.models.product.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.collections.find
import kotlin.collections.mutableSetOf


class CartRepository : ICartRepository
{

    private val _products = MutableStateFlow<MutableSet<Product>>(mutableSetOf())
    override val products: StateFlow<Set<Product>> = _products.asStateFlow()

    private val _productCount = MutableStateFlow(0)
    override val productCount: StateFlow<Int> = _productCount.asStateFlow()

    override fun add(product: Product) {

        val current = _products.value.toMutableSet()

        // See if this product (by id) is already in the cart
        val existing = current.find { it.id == product.id }

        if (existing != null) {
            // If it is, bump its quantity by the unit's default increment
            product.quantity = existing.quantity + product.unit.defaultIncrement
        } else {
            // If it's new, add with quantity = defaultIncrement
            current.add(product);

            product.quantity = product.unit.defaultIncrement;
        }

        println("${product.quantity} Quantittyyyyy")

        // Publish the updated set and recompute total count
        _products.value = current
        // Optional: if you want total quantity instead of distinct count,
        // you could sum up the quantities here:
        _productCount.value = _products.value.size
    }
}