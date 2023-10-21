package com.example.demo.services;

import com.example.demo.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService implements CommandLineRunner {

    private final List<Recipe> recipeList = new ArrayList<>();

    public Recipe getRecipe(int id) {
        return recipeList.get(id - 1);
    }

    public Recipe createRecipe(Recipe recipe) {
        Recipe newRecipe = Recipe.builder()
                .name(recipe.getName())
                .description(recipe.getDescription())
                .ingredients(recipe.getIngredients())
                .directions(recipe.getDirections())
                .build();
        return newRecipe;
    }

    @Override
    public void run(String... args) {
        Recipe recipe = new Recipe();
        recipeList.add(recipe);
    }
}
