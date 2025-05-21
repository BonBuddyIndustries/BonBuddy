package com.example.bonbuddy.repos.product

import com.example.bonbuddy.models.product.Product
import com.example.bonbuddy.models.product.ProductCategory
import com.example.bonbuddy.models.product.ProductUnit

class ProductRepository : IProductRepository
{
    val products = listOf(
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

    override fun getByCategory(category: ProductCategory): List<Product>
    {
        return products.filter { x -> x.category == category }
    }
}