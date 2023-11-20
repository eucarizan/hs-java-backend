package com.example.demo.controllers;

import com.example.demo.models.Recipe;
import com.example.demo.models.User;
import com.example.demo.services.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) {
        return ResponseEntity.of(recipeService.findById(id));
    }

    @PostMapping("/recipe/new")
    public Map<String, Long> addRecipe(@Valid @RequestBody Recipe recipe, @AuthenticationPrincipal UserDetails user) {
        return Map.of("id", recipeService.add(recipe, user));
    }

    @DeleteMapping("/recipe/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable long id, @AuthenticationPrincipal UserDetails user) {
        return recipeService.deleteById(id, user);
    }

    @GetMapping(value = "/recipe/search", params = "name")
    public ResponseEntity<List<Recipe>> getRecipesByName(@RequestParam String name) {
        return recipeService.getRecipesByName(name);
    }

    @GetMapping(value = "/recipe/search", params = "category")
    public ResponseEntity<List<Recipe>> getRecipesByCategory(@RequestParam String category) {
        return recipeService.getRecipesByCategory(category);
    }

    @PutMapping("/recipe/{id}")
    public ResponseEntity<Void> updateRecipe(@PathVariable long id, @Valid @RequestBody Recipe recipe) {
        boolean status = recipeService.updateById(id, recipe);
        return status ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public ResponseEntity<Void> addUser(@Valid @RequestBody User user) {
        boolean status = recipeService.registerUser(user);
        return status ?
                ResponseEntity.ok().build() :
                ResponseEntity.badRequest().build();
    }

    // TODO: extra - create data.sql to insert data to DB
}
