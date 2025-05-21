package com.example.bonbuddy.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bonbuddy.screens.AppScreens
import com.example.bonbuddy.screens.ProductByCategoryScreen
import com.example.bonbuddy.screens.ProductSearchScreen
import com.example.bonbuddy.screens.CartScreen
import com.example.bonbuddy.components.navigation.BottomNavigationBar
import com.example.bonbuddy.models.product.ProductCategory
import com.example.bonbuddy.screens.ABC
import com.example.bonbuddy.screens.ShoppingListOverviewScreen

@Composable
fun MainLayout()
{
    val navController = rememberNavController()


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        NavHost(
            navController  = navController,
            startDestination = AppScreens.ShoppingListOverviewScreen.route,
            modifier = Modifier
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.surfaceContainerLowest)
        ) {
            composable(AppScreens.ShoppingListOverviewScreen.route) {
                ShoppingListOverviewScreen(navController)
            }
            composable(AppScreens.ProductSearchScreen.route) {
                ProductSearchScreen(navController)
            }
            composable(AppScreens.CartScreen.route) {
                CartScreen(navController)
            }

            composable(AppScreens.afkjawpj.route) {
                ABC(navController)
            }

            composable(
                route = AppScreens.ProductByCategoryScreen.route,
                arguments = listOf(navArgument("category") {
                    type = NavType.EnumType(ProductCategory::class.java)
                })
            ) { backStackEntry ->

                val args = backStackEntry.arguments



                val category = (args?.getSerializable("category") as? ProductCategory)

                if (category == null)
                {
                    error("ProductByCategoryScreen: missing or invalid 'category' argument")
                }

                ProductByCategoryScreen(navController, category)
            }
        }
    }
}


