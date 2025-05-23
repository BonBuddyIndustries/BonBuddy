package com.example.bonbuddy.models.shoppingList

import com.example.bonbuddy.models.product.SLProduct
import com.example.bonbuddy.models.retailer.Retailer
import java.util.Date
import java.util.UUID

data class ShoppingList(val id: UUID = UUID.randomUUID(),
                        var date: Date,
                        var retailer: Retailer,
                        var products : Set<SLProduct>)