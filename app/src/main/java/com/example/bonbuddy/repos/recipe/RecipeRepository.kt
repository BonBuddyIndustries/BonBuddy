package com.example.bonbuddy.repos.recipe

class RecipeRepository : IRecipeRepository
{
    override fun getRecommended(): List<String>
    {
        val recipeNames = listOf(
            "Rezept 1", "Rezept 2", "Rezept 3", "Rezept 4",
            "Rezept 5", "Rezept 6", "Rezept 7", "Rezept 8"
        )

        return recipeNames;
    }
}

