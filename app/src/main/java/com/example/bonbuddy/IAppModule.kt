package com.example.bonbuddy

import android.content.Context
import com.example.bonbuddy.repos.cart.CartRepository
import com.example.bonbuddy.repos.cart.ICartRepository
import com.example.bonbuddy.repos.product.IProductRepository
import com.example.bonbuddy.repos.product.ProductRepository
import com.example.bonbuddy.repos.recipe.IRecipeRepository
import com.example.bonbuddy.repos.recipe.RecipeDBRepository
import com.example.bonbuddy.repos.recipe.RecipeRepository

interface IAppModule {
    val cartRepository: ICartRepository
    val productRepository: IProductRepository
    val recipeRepository: IRecipeRepository
}

class AppModule(appContext: Context) : IAppModule {
    override val cartRepository: ICartRepository by lazy { CartRepository() }
    override val productRepository: IProductRepository by lazy { ProductRepository() }
    override val recipeRepository: IRecipeRepository by lazy { RecipeDBRepository() }
}