package com.example.bonbuddy.repos.product

import com.example.bonbuddy.models.product.Product
import com.example.bonbuddy.models.product.ProductCategory

interface IProductRepository {
    fun getByCategory(category: ProductCategory): List<Product>
}