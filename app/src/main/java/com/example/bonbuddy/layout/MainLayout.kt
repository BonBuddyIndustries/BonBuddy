package com.example.bonbuddy.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bonbuddy.screens.AppScreenRoutes
import com.example.bonbuddy.screens.ProductByCategoryScreen
import com.example.bonbuddy.screens.ProductSearchScreen
import com.example.bonbuddy.screens.CartScreen
import com.example.bonbuddy.components.navigation.BottomNavigationBar
import com.example.bonbuddy.models.product.ProductCategory
import com.example.bonbuddy.screens.ShoppingListOverviewScreen

val LocalNavController = staticCompositionLocalOf<NavHostController> {
    error("No NavController provided")
}

@Composable
fun MainLayout()
{
    val navController = rememberNavController()

    /* Provides a NavController throughout all screens
       use via: val navController = LocalNavController.current */

    CompositionLocalProvider(
        LocalNavController provides navController
    )
    {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { BottomNavigationBar(navController) }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = AppScreenRoutes.ShoppingListOverviewScreenRoute.route,
                modifier = Modifier
                    .padding(paddingValues)
                    .background(MaterialTheme.colorScheme.surfaceContainerLowest)
            ) {
                composable(AppScreenRoutes.ShoppingListOverviewScreenRoute.route) {
                    ShoppingListOverviewScreen()
                }
                composable(AppScreenRoutes.ProductSearchScreenRoute.route) {
                    ProductSearchScreen()
                }
                composable(AppScreenRoutes.CartScreenRoute.route) {
                    CartScreen()
                }
                composable(
                    route = AppScreenRoutes.ProductByCategoryScreenRoute.route,
                    arguments = listOf(navArgument("category") {
                        type = NavType.EnumType(ProductCategory::class.java)
                    })
                ) { backStackEntry ->

                    val args = backStackEntry.arguments

                    val category = (args !!.getSerializable("category") as ProductCategory)


                    ProductByCategoryScreen(category)
                }
            }
        }
    }


}


