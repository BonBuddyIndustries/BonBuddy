package com.example.bonbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bonbuddy.layout.MainLayout
import com.example.bonbuddy.ui.theme.BonBuddyTheme
import com.example.bonbuddy.viewModels.AppViewModels
import com.example.bonbuddy.viewModels.cart.CartViewModel
import com.example.bonbuddy.viewModels.viewModelFactory

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppViewModelsProvider {
                BonBuddyTheme {
                    Surface(Modifier.fillMaxSize()) {
                        MainLayout()
                    }
                }
            }
        }

    }

    @Composable
    fun AppViewModelsProvider(content: @Composable () -> Unit) {

        val cartViewModel = viewModel<CartViewModel>(
            factory = viewModelFactory { CartViewModel(BonBuddyApp.appModule.cartRepository) }
        )

        val appViewModels = remember(cartViewModel /*, otherViewModel */) {
            AppViewModels(cartViewModel /*, otherViewModel */)
        }

        CompositionLocalProvider(LocalAppViewModels provides appViewModels, content = content)
    }
}

val LocalAppViewModels = staticCompositionLocalOf<AppViewModels> {
    error("AppViewModels not present")
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier)
{
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}