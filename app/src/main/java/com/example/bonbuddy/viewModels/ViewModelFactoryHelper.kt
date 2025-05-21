package com.example.bonbuddy.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

fun <VM : ViewModel> viewModelFactory(initializer: () -> VM): ViewModelProvider.Factory =
    object : ViewModelProvider.Factory
    {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T = initializer() as T
    }