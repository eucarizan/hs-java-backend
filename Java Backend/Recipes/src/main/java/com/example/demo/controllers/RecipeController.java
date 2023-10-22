package com.example.demo.controllers;

import com.example.demo.dtos.CreateRecipeDTO;
import com.example.demo.models.Recipe;
import com.example.demo.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        return ResponseEntity.of(recipeService.findById(id));
    }

    @PostMapping("/recipe/new")
    public ResponseEntity<CreateRecipeDTO> createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

}
