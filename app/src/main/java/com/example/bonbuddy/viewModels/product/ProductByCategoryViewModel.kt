package com.example.bonbuddy.viewmodel.product

import androidx.lifecycle.ViewModel
import com.example.bonbuddy.models.product.Product
import com.example.bonbuddy.models.product.ProductCategory
import com.example.bonbuddy.repos.product.IProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductByCategoryViewModel @Inject constructor(private val productRepo: IProductRepository) :
    ViewModel()
{
    fun addProdct(product: Product)
    {
        productRepo.add(product)
    }

    fun getAllProducts(): Set<Product>
    {
        return productRepo.getAll()
    }

    fun getProductByCategory(category: ProductCategory): Set<Product>
    {
        return productRepo.getByCategory(category)
    }
}