package com.example.bonbuddy.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bonbuddy.BonBuddyApp
import com.example.bonbuddy.LocalAppViewModels
import com.example.bonbuddy.models.product.ProductUnit

@Composable
fun CartScreen(navController: NavController)
{
    val cartViewModel = LocalAppViewModels.current.cartViewModel

    val products = cartViewModel.products.collectAsState().value

    if (products.isEmpty())
    {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Einkaufszettel ist leer")
        }
    } else
    {
        Column(Modifier.fillMaxSize())
        {
            products.forEach { product ->

                Text(text = "${product.title} ${product.quantity} ${product.unit.label}")
            }

        }
    }


}