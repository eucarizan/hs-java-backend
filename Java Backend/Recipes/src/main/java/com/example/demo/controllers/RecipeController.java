package com.example.demo.controllers;

import com.example.demo.dtos.CreateRecipeDTO;
import com.example.demo.models.Recipe;
import com.example.demo.services.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

//    @PostMapping("/new")
//    public ResponseEntity<CreateRecipeDTO> createRecipe(@Valid @RequestBody Recipe recipe) {
//        return recipeService.createRecipe(recipe);
//    }

    @PostMapping("/new")
    public Map<String, Long> addRecipe(@Valid @RequestBody Recipe recipe) {
        return Map.of("id", recipeService.add(recipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable long id) {
//        return recipeService.deleteRecipe(id);
        boolean status = recipeService.deleteById(id);
        return status ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/search", params = "name")
    public ResponseEntity<List<Recipe>> getRecipesByName(@RequestParam String name) {
        return recipeService.getRecipesByName(name);
    }

    @GetMapping(value = "/search", params = "category")
    public ResponseEntity<List<Recipe>> getRecipesByCategory(@RequestParam String category) {
        return recipeService.getRecipesByCategory(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRecipe(@PathVariable long id, @Valid @RequestBody Recipe recipe) {
//        return recipeService.updateRecipe(id, recipe);
        boolean status = recipeService.updateById(id, recipe);
        return status ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    // TODO: extra - create data.sql to insert data to DB
}
