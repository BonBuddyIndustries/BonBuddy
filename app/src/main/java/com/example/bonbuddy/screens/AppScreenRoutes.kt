package com.example.bonbuddy.screens

import com.example.bonbuddy.models.product.ProductCategory

sealed class AppScreenRoutes(val route : String) {
    object ShoppingListOverviewScreenRoute : AppScreenRoutes("shopping_list_overview_screen")
    object ProductSearchScreenRoute : AppScreenRoutes("product_search_screen")
    object CartScreenRoute : AppScreenRoutes("cart_screen")
    object ProductByCategoryScreenRoute : AppScreenRoutes("product_by_category_screen/{category}") {
        fun createRoute(category: ProductCategory) = "product_by_category_screen/${category.name}"
    }
}