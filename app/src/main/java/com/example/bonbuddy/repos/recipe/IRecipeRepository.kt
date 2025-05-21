package com.example.bonbuddy.repos.recipe


interface IRecipeRepository {
    fun getRecommended(): List<String>
}