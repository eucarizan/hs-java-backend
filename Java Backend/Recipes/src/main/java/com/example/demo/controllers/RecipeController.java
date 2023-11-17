package com.example.demo.controllers;

import com.example.demo.dtos.CreateRecipeDTO;
import com.example.demo.models.Recipe;
import com.example.demo.services.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) {
        return ResponseEntity.of(recipeService.findById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<CreateRecipeDTO> createRecipe(@Valid @RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable long id) {
        return recipeService.deleteRecipe(id);
    }

}
