package com.example.bonbuddy.repos.cart

import com.example.bonbuddy.models.product.Product
import kotlinx.coroutines.flow.StateFlow

interface ICartRepository {
    val products: StateFlow<Set<Product>>
    val productCount: StateFlow<Int>
    fun add(product: Product)
}