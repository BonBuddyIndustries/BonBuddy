package com.example.bonbuddy.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bonbuddy.viewmodel.theme.ThemeViewModel


@Composable
fun ShoppingListOverviewScreen()
{
    val themeViewModel = hiltViewModel<ThemeViewModel>()
    val isDarkMode by themeViewModel.isDarkMode.collectAsState()

    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Dark mode")
        Spacer(Modifier.weight(1f))
        Switch(
            checked = isDarkMode,
            onCheckedChange = { themeViewModel.toggleDarkMode() }
        )
    }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Keine Einkaufszettel vorhanden")
    }
}