package com.example.demo.services;

import com.example.demo.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    private Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }

    public Recipe createRecipe(Recipe recipe) {
        this.recipe = Recipe.builder()
                .name(recipe.getName())
                .description(recipe.getDescription())
                .ingredients(recipe.getIngredients())
                .directions(recipe.getDirections())
                .build();
        return this.recipe;
    }
}
