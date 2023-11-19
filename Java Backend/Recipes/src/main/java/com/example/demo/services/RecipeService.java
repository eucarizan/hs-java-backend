package com.example.demo.services;

import com.example.demo.models.Recipe;
import com.example.demo.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public long add(Recipe recipe) {
        return recipeRepository.save(recipe).getId();
    }

    public boolean deleteById(long id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ResponseEntity<List<Recipe>> getRecipesByName(String name) {
        return ResponseEntity.ok(recipeRepository.findByNameIgnoreCaseContainsOrderByDateDesc(name));
    }

    public ResponseEntity<List<Recipe>> getRecipesByCategory(String category) {
        return ResponseEntity.ok(recipeRepository.findByCategoryIgnoreCaseOrderByDateDesc(category));
    }

    public boolean updateById(long id, Recipe recipe) {
        var recipeToUpdate = findById(id);

        if (recipeToUpdate.isPresent()) {
            Recipe oldRecipe = recipeToUpdate.get();
            oldRecipe.copyOf(recipe);
            recipeRepository.save(oldRecipe);
            return true;
        }

        return false;
    }
}
