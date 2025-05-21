package com.example.bonbuddy.models.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasBadge: Boolean = false,
    val badgeCount: Int = 0
)