package com.example.bonbuddy.models.product

enum class ProductCategory(var title: String)
{
    FRUIT("Obst"), VEGETABLES("Gemüse"), FISH_AND_MEAT("Fisch & Fleisch"), DAIRY("Milchprodukte"),
    BREAD("Getränke"), DRINKS("Drogerie"), DRUGSTORE("Haushalt"), HOUSEHOLD("Haushalt"), OTHER("Sonstiges");

    override fun toString(): String {
        return title
    }
}