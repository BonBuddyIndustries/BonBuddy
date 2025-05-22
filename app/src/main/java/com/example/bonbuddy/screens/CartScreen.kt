package com.example.bonbuddy.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bonbuddy.viewmodel.product.ProductByCategoryViewModel


@Composable
fun CartScreen()
{
    val viewModel  = hiltViewModel<ProductByCategoryViewModel>()
    val products = viewModel.getAllProducts()



    Column(Modifier.fillMaxSize()) {
        products.forEach { product -> Text("${product.title} - ${product.quantity}${product.unit.label}") }
    }


//    val cartViewModel = hiltViewModel<CartViewModel>()
//    val cartProducts by cartViewModel.products.collectAsState()
//
//    if (cartProducts.isEmpty())
//    {
//        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            Text("Einkaufszettel ist leer")
//        }
//    }
//    else
//    {
//        Column(Modifier.fillMaxSize()) {
//            cartProducts.forEach { product -> Text("${product.title} - ${product.quantity}${product.unit.label}") }
//        }
//
//    }


}