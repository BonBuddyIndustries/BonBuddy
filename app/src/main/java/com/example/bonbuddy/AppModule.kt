package com.example.bonbuddy

import com.example.bonbuddy.repos.cart.CartRepository
import com.example.bonbuddy.repos.cart.ICartRepository
import com.example.bonbuddy.repos.product.IProductRepository
import com.example.bonbuddy.repos.product.ProductRepository
import com.example.bonbuddy.repos.theme.IThemeRepository
import com.example.bonbuddy.repos.theme.ThemeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule()
{
    @Provides
    @Singleton
    fun provideCartRepository() : ICartRepository
    {
        return CartRepository()
    }

    @Provides
    @Singleton
    fun provideProductRepository() : IProductRepository
    {
        return ProductRepository()
    }

    @Provides
    @Singleton
    fun provideThemeRepository() : IThemeRepository
    {
        return ThemeRepository()
    }
}