package com.example.bonbuddy.screens

import com.example.bonbuddy.models.product.ProductCategory

sealed class AppScreens(val route : String) {
    object ShoppingListOverviewScreen : AppScreens("shopping_list_overview_screen")
    object ProductSearchScreen : AppScreens("product_search_screen")
    object afkjawpj : AppScreens("afkjawpj")
    object CartScreen : AppScreens("cart_screen")
    object ProductByCategoryScreen : AppScreens("product_by_category_screen/{category}") {
        fun createRoute(category: ProductCategory) = "product_by_category_screen/${category.name}"
    }
}