package com.example.bonbuddy.viewModels.cart

import androidx.lifecycle.ViewModel
import com.example.bonbuddy.models.product.Product
import com.example.bonbuddy.repos.cart.ICartRepository
import kotlinx.coroutines.flow.StateFlow

class CartViewModel(private val cartRepository: ICartRepository) : ViewModel()
{
    val products: StateFlow<Set<Product>> = cartRepository.products
    val productCount: StateFlow<Int> = cartRepository.productCount

    fun addToCart(product: Product) = cartRepository.add(product)
}
