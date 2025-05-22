package com.example.bonbuddy.repos.cart

import com.example.bonbuddy.models.product.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.find
import kotlin.collections.mutableSetOf


class CartRepository : ICartRepository
{

    private val _products = MutableStateFlow<MutableSet<Product>>(mutableSetOf())
    override val products: StateFlow<Set<Product>> = _products.asStateFlow()

    private val _productCount = MutableStateFlow(0)
    override val productCount: StateFlow<Int> = _productCount.asStateFlow()

    override fun add(product: Product)
    {

        val current = _products.value.toMutableSet()


        val existing = current.find { it.id == product.id }

        if (existing != null)
        {
            product.quantity = existing.quantity + product.unit.defaultIncrement
        }
        else
        {

            current.add(product);

            product.quantity = product.unit.defaultIncrement;
        }

        _products.value = current

        _productCount.value = _products.value.size
    }
}