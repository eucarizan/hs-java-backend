package dev.njeu.web;

import dev.njeu.entities.Recipe;
import dev.njeu.entities.User;
import dev.njeu.service.RecipeService2;
import dev.njeu.web.mapper.RecipeMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private final RecipeService2 recipeService;
    private final RecipeMapper recipeMapper;

    public RecipeController(RecipeService2 recipeService, RecipeMapper recipeMapper) {
        this.recipeService = recipeService;
        this.recipeMapper = recipeMapper;
    }

    @PostMapping("/new")
    public Map<String, Long> addRecipe(@Valid @RequestBody Recipe recipe, @AuthenticationPrincipal UserDetails user) {
        return Map.of("id", recipeService.add(recipe, user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) {
        return ResponseEntity.of(recipeService.findById(id));
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
    public ResponseEntity<Void> updateRecipe(
            @PathVariable long id,
            @Valid @RequestBody Recipe recipe,
            @AuthenticationPrincipal UserDetails user) {
        return recipeService.updateById(id, recipe, user);
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
