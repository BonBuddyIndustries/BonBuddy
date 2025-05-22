package com.example.bonbuddy.repos.product

import com.example.bonbuddy.models.product.Product
import com.example.bonbuddy.models.product.ProductCategory

interface IProductRepository {

    fun getAll(): Set<Product>;

    fun getByCategory(category: ProductCategory): Set<Product>

    fun add(product: Product)

    fun remove(product: Product)

    fun update(product: Product): Boolean
}