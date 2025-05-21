package com.example.bonbuddy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bonbuddy.BonBuddyApp
import com.example.bonbuddy.LocalAppViewModels
import com.example.bonbuddy.R
import com.example.bonbuddy.extensions.dropShadow
import com.example.bonbuddy.models.product.Product
import com.example.bonbuddy.models.product.ProductCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductByCategoryScreen(navController: NavHostController, category: ProductCategory)
{
    val repo = BonBuddyApp.appModule.productRepository
    val productsByCategory = remember(category) { repo.getByCategory(category) }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            modifier = Modifier
                .background(Color.Green)
                .padding(0.dp),
            title = { Text(category.toString(), style = TextStyle(fontSize = 18.sp)) },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Produktsuche")
                }
            },
//            colors = TopAppBarDefaults.topAppBarColors(
//                containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
//                titleContentColor = MaterialTheme.colorScheme.onSurface,
//                navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
//                actionIconContentColor = MaterialTheme.colorScheme.onSurface
//            ),
            expandedHeight = 48.dp,
            windowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp)
        )


        if (productsByCategory.isEmpty())
        {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Keine Produkte vorhanden für ${category}", style = TextStyle(fontSize = 18.sp))
            }


        }
        else
        {
            ProductCardGrid(productsByCategory)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCardGrid(productsByCategory: List<Product>)
{
    val cartViewModel = LocalAppViewModels.current.cartViewModel

    LazyVerticalGrid(
        columns = GridCells.Adaptive(168.dp),


        contentPadding = PaddingValues(12.dp, 24.dp),

        horizontalArrangement = Arrangement.spacedBy(24.dp),

        verticalArrangement = Arrangement.spacedBy(32.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(productsByCategory) { product ->
            ProductCard(
                product = product,
                onClick = { cartViewModel.addToCart(product) }
            )
        }
    }


}

@Composable
fun ProductCard(modifier: Modifier = Modifier,
                product: Product,
                imageID: Int = R.drawable.ic_placeholder,
                onClick: () -> Unit
)
{
    Box(
        modifier = modifier
            .fillMaxWidth()
            .dropShadow(shape = RoundedCornerShape(10), spread = 4.dp)
            .clip(shape = RoundedCornerShape(10)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceContainer)
                .padding(8.dp, 16.dp, 8.dp, 8.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            Image(
                painter = painterResource(id = imageID),
                contentDescription = "Image of ${product.title}",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(134.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .align(Alignment.CenterHorizontally)
                    .clickable(onClick = onClick)

            )

            Text(
                text = product.title,
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp)
            )

            Surface(
                color = MaterialTheme.colorScheme.surfaceContainerLowest,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(28.dp)
                    .clip(shape = RoundedCornerShape(4.dp))
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.outlineVariant,
                        RoundedCornerShape(4.dp)
                    )
            ) {

            }

            Text(
                text = product.unit.label,
                style = MaterialTheme.typography.titleSmall,
            )
        }
    }

}