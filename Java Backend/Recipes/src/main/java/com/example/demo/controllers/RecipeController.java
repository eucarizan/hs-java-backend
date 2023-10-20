package com.example.demo.controllers;

import com.example.demo.models.Recipe;
import com.example.demo.services.RecipeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe")
    public Recipe getRecipe() {
        return recipeService.getRecipe();
    }

    @PostMapping("/recipe")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

}
