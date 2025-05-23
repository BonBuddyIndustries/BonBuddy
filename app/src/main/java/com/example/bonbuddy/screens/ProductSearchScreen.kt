package com.example.bonbuddy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bonbuddy.R
import com.example.bonbuddy.layout.LocalNavController
import com.example.bonbuddy.models.product.Product
import com.example.bonbuddy.models.product.ProductCategory
import com.example.bonbuddy.models.product.ProductUnit
import com.example.bonbuddy.screens.AppScreenRoutes.ProductByCategoryScreenRoute
import com.example.bonbuddy.viewmodel.product.ProductByCategoryViewModel
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductSearchScreen()
{
    val textFieldState = remember { TextFieldState() }

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Spacer(Modifier.height(16.dp))

        SimpleSearchBarMinimal(
            textFieldState = textFieldState,
            onSearch = { /* no-op */ },
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .align(alignment = Alignment.CenterHorizontally)
        )


        Spacer(Modifier.height(48.dp))

        Text(
            "Empfohlene Rezepte",
            modifier = Modifier.padding(PaddingValues(horizontal = 16.dp)),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )

        RecipeRecommendationList()

        Spacer(Modifier.height(32.dp))

        Text(
            "Weitere Rezepte",
            modifier = Modifier.padding(PaddingValues(horizontal = 16.dp)),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary
        )

        RecipeList()
        HorizontalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outlineVariant,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 4.dp)
        )

        Spacer(Modifier.height(32.dp))

        Text(
            "Produktkategorien",
            modifier = Modifier.padding(PaddingValues(horizontal = 16.dp)),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(Modifier.height(2.dp))

        ProductList()

        Spacer(Modifier.height(32.dp))

    }
}

@Composable
fun SimpleSearchBarMinimal(
    textFieldState: TextFieldState,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier
)
{
    TextField(
        value = textFieldState.text.toString(),
        onValueChange = { textFieldState.edit { replace(0, length, it) } },
        modifier = modifier
            .height(56.dp)
            .clip(RoundedCornerShape(28.dp)),
        placeholder = { Text("Search") },
        singleLine = true,
        shape = RoundedCornerShape(28.dp),
        colors = TextFieldDefaults.colors()
    )
}



@Composable
fun RecipeRecommendationList()
{
    val recipeNames = listOf(
        "Rezept 1", "Rezept 2", "Rezept 3", "Rezept 4",
        "Rezept 5", "Rezept 6", "Rezept 7", "Rezept 8"
    )

    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp, 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        recipeNames.forEach { name ->
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.Transparent
            ) {
                RecipeRecommendationItem(
                    itemName = name,
                    onClick = { /* TODO: Rezept Screen */ }
                )
            }
        }
    }


}

@Composable
fun RecipeRecommendationItem(itemName: String,
                             imageID: Int = R.drawable.ic_placeholder,
                             onClick: () -> Unit
)
{
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageID),
            contentDescription = "Image of $itemName",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(85.dp)
                .clip(RoundedCornerShape(16.dp))
                .clickable(onClick = onClick)

        )

        Text(
            text = itemName,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}


@Composable
fun RecipeList()
{
    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxWidth()
    ) {
        ImageListItem(
            itemName = "Alle Rezepte",
            onClick = { /* TODO: Alle Rezepte Screen */ }
        )
    }

    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxWidth()
    ) {
        ImageListItem(
            itemName = "Eigenes Rezept hinzufügen",
            onClick = { /* TODO: open dialog */ }
        )
    }
}

@Composable
fun ProductList()
{
    val productCategories = ProductCategory.entries

    productCategories.forEach { category ->
        Surface(
            color = MaterialTheme.colorScheme.surface,
            modifier = Modifier.fillMaxWidth()
        ) {
            val navController = LocalNavController.current

            ImageListItem(
                itemName = category.toString(),
                onClick = { navController.navigate(ProductByCategoryScreenRoute.createRoute(category)) }
            )
        }
    }

    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxWidth()
    ) {
        ImageListItem(
            itemName = "Favoriten",
            onClick = { /* TODO: open dialog */ }
        )
    }

    val viewModel  = hiltViewModel<ProductByCategoryViewModel>()

    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxWidth()
    ) {
        ImageListItem(
            itemName = "Eigenes Produkt hinzufügen",
            onClick =
                {
                    viewModel.addProdct(Product(

                        id = UUID.fromString("550E8400-e29b-41d4-A716-446655440000"),
                        title = "FUCKFUCKFUCKFUCKFUCKFUCKFUCKFUCKFUCKFUCKFUCKFUCK",
                        unit = ProductUnit.GRAM,
                        category = ProductCategory.FRUIT
                    ))
                }
        )
    }


}

@Composable
fun ImageListItem(
    itemName: String,
    imageID: Int = R.drawable.ic_placeholder,
    onClick: () -> Unit
)
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageID),
            contentDescription = "Image of $itemName",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(6.dp))

        )

        Spacer(Modifier.width(12.dp))

        Text(
            text = itemName,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Icon(Icons.AutoMirrored.Filled.ArrowRight, contentDescription = "Go to $itemName")
    }
}
