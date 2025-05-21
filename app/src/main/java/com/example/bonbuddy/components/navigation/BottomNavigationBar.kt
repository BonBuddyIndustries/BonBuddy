package com.example.bonbuddy.components.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bonbuddy.LocalAppViewModels
import com.example.bonbuddy.screens.AppScreens
import com.example.bonbuddy.models.navigation.BottomNavigationItem

@Composable
fun BottomNavigationBar(navController: NavHostController)
{
    val navEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navEntry?.destination?.route

    val cartViewModel = LocalAppViewModels.current.cartViewModel
    val cartCount by cartViewModel.productCount.collectAsState()

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.drawBehind {
            drawRect(
                Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black),
                    startY = - 45f,
                    endY = size.height
                ),
                topLeft = Offset(0f, - 45f)
            )
        }
    ) {

        var bottomNavItems = createBottomNavigationItems(cartCount);

        bottomNavItems.forEach { item ->
            val selected = item.route == currentRoute

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    BadgedBox(badge = {
                        if (item.badgeCount != 0)
                        {
                            Badge(Modifier.padding(4.dp, 0.dp, 0.dp, 2.dp)) {
                                Text(item.badgeCount.toString())
                            }
                        }
                    }) {
                        Icon(
                            imageVector = if (selected) item.selectedIcon else item.unselectedIcon,
                            contentDescription = item.title
                        )
                    }
                },
                label = { Text(item.title) }
            )
        }
    }
}

private fun createBottomNavigationItems(cartItemCount: Int): List<BottomNavigationItem>
{
    return listOf(
        BottomNavigationItem(
            title = "Meine Einkäufe",
            route = AppScreens.ShoppingListOverviewScreen.route,
            selectedIcon = Icons.AutoMirrored.Filled.List,
            unselectedIcon = Icons.AutoMirrored.Outlined.List
        ),
        BottomNavigationItem(
            title = "Produktsuche",
            route = AppScreens.ProductSearchScreen.route,
            selectedIcon = Icons.Filled.Search,
            unselectedIcon = Icons.Outlined.Search
        ),
        BottomNavigationItem(
            title = "Mein Einkaufszettel",
            route = AppScreens.CartScreen.route,
            selectedIcon = Icons.Filled.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart,
            hasBadge = true,
            badgeCount = cartItemCount
        )
    )
}