package com.example.bonbuddy.viewmodel.cart

import androidx.lifecycle.ViewModel
import com.example.bonbuddy.models.product.Product
import com.example.bonbuddy.repos.cart.ICartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class CartViewModel @Inject constructor (private val cartRepository: ICartRepository) : ViewModel()
{
    val products: StateFlow<Set<Product>> = cartRepository.products
    val productCount: StateFlow<Int> = cartRepository.productCount

    fun addToCart(product: Product) = cartRepository.add(product)
}