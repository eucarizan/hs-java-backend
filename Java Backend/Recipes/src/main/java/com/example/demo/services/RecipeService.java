package com.example.demo.services;

import com.example.demo.dtos.CreateRecipeDTO;
import com.example.demo.models.Recipe;
import com.example.demo.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Optional<Recipe> findById(long id) {
        return recipeRepository.findById(id);
    }

    public ResponseEntity<CreateRecipeDTO> createRecipe(Recipe recipe) {
        Recipe savedRecipe = recipeRepository.save(recipe);

        CreateRecipeDTO recipeDTO = new CreateRecipeDTO(savedRecipe.getId());

        return ResponseEntity.ok(recipeDTO);
    }

    public ResponseEntity<Void> deleteRecipe(long id) {
        var recipe = findById(id);

        if (recipe.isPresent()) {
            recipeRepository.delete(recipe.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Recipe>> getRecipesByName(String name) {
        return ResponseEntity.ok(recipeRepository.findByNameIgnoreCaseContainsOrderByDateDesc(name));
    }

    public ResponseEntity<List<Recipe>> getRecipesByCategory(String category) {
        return ResponseEntity.ok(recipeRepository.findByCategoryIgnoreCaseOrderByDateDesc(category));
    }

    public ResponseEntity<Void> updateRecipe(long id, Recipe recipeUpdate) {
        var recipe = findById(id);

        if (recipe.isPresent()) {
            var updatedRecipe = new Recipe(recipe.get().getId(),
                    recipeUpdate.getName(),
                    recipeUpdate.getCategory(),
                    recipeUpdate.getDescription(),
                    LocalDateTime.now(),
                    recipeUpdate.getIngredients(),
                    recipeUpdate.getDirections());
            recipeRepository.save(updatedRecipe);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
