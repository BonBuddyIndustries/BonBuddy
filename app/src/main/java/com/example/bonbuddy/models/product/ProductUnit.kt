package com.example.bonbuddy.models.product

enum class ProductUnit(
    val defaultIncrement: Int,
    val label: String,
    val labelOther: String
) {
    GRAM(100, "Gramm", "kg"),
    ML(500, "Liter", "l"),
    PIECE(1, "Stück", "Stk.");
}