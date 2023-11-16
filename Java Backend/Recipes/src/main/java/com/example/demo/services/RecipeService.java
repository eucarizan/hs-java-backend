package com.example.demo.services;

import com.example.demo.dtos.CreateRecipeDTO;
import com.example.demo.models.Recipe;
import com.example.demo.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
