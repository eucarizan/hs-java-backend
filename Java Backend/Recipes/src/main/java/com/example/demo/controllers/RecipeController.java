package com.example.demo.controllers;

import com.example.demo.models.Recipe;
import com.example.demo.services.RecipeService;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    public Recipe getRecipe(@PathVariable int id) {
        return recipeService.getRecipe(id);
    }

    @PostMapping("/recipe/new")
    public ResponseEntity<String> createRecipe(@RequestBody Recipe recipe) throws JsonProcessingException {
        return recipeService.createRecipe(recipe);
    }

}
