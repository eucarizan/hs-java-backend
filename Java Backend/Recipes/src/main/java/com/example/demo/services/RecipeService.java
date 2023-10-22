package com.example.demo.services;

import com.example.demo.dtos.CreateRecipeDTO;
import com.example.demo.models.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RecipeService {

    private final Map<Integer, Recipe> recipeList = new HashMap<>();
    private int count;

    public RecipeService() {
        Recipe recipe = new Recipe();
        count = 0;
        recipeList.put(count, recipe);
    }

    public Optional<Recipe> findById(int id) {
        return Optional.ofNullable(recipeList.get(id));
    }

    public ResponseEntity<CreateRecipeDTO> createRecipe(Recipe recipe) {
        int id = count;
        recipeList.put(id, recipe);
        CreateRecipeDTO recipeDTO = new CreateRecipeDTO(id);
        incrementId();

        return ResponseEntity.ok(recipeDTO);
    }

    private void incrementId() {
        count++;
    }
}
