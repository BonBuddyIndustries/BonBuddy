package com.example.bonbuddy.repos.product

import com.example.bonbuddy.models.product.Product
import com.example.bonbuddy.models.product.ProductCategory
import com.example.bonbuddy.models.product.ProductUnit

class ProductRepository : IProductRepository
{
    private val _products: MutableSet<Product> = mutableSetOf(
        Product(
            title = "Äpfel",
            unit = ProductUnit.GRAM,
            category = ProductCategory.FRUIT
        ),

        Product(
            title = "Bananen",
            unit = ProductUnit.GRAM,
            category = ProductCategory.FRUIT
        ),

        Product(
            title = "Weintrauben",
            unit = ProductUnit.GRAM,
            category = ProductCategory.FRUIT
        ),
        Product(
            title = "Wassermelonen",
            unit = ProductUnit.PIECE,
            category = ProductCategory.FRUIT
        ),
        Product(
            title = "Erdbeeren",
            unit = ProductUnit.GRAM,
            category = ProductCategory.FRUIT
        ),
        Product(
            title = "Granatäpfel",
            unit = ProductUnit.GRAM,
            category = ProductCategory.FRUIT
        ),
    );


    override fun getAll(): Set<Product>
    {
        return _products.toSet()
    }


    override fun getByCategory(category: ProductCategory): Set<Product>
    {
        return _products.filter { it.category == category }.toSet()
    }


    override fun add(product: Product)
    {
        _products.add(product)
    }

    override fun remove(product: Product)
    {
        _products.remove(product)
    }

    override fun update(product: Product): Boolean {
        val existing = _products.find { it == product }

        if (existing == null)
        {
            return false;
        }

        existing.title      = product.title
        existing.unit       = product.unit
        existing.category   = product.category
        existing.isFavorite = product.isFavorite

        return true
    }
}