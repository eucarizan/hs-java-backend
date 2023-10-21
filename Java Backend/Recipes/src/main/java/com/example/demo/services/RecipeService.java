package com.example.demo.services;

import com.example.demo.dtos.CreateRecipeDTO;
import com.example.demo.exceptions.RecipeNotFoundException;
import com.example.demo.models.Recipe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService implements CommandLineRunner {

    private final List<Recipe> recipeList = new ArrayList<>();

    public Recipe getRecipe(int id) {
        if (id - 1 >= recipeList.size()) {
            throw new RecipeNotFoundException();
        }
        return recipeList.get(id - 1);
    }

    public ResponseEntity<String> createRecipe(Recipe recipe) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Recipe newRecipe = Recipe.builder()
                .name(recipe.getName())
                .description(recipe.getDescription())
                .ingredients(recipe.getIngredients())
                .directions(recipe.getDirections())
                .build();
        recipeList.add(newRecipe);
        int index = recipeList.size();
        CreateRecipeDTO recipeDTO = new CreateRecipeDTO(index);

        return new ResponseEntity<>(objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(recipeDTO), HttpStatus.OK);
    }

    @Override
    public void run(String... args) {
        Recipe recipe = new Recipe();
        recipeList.add(recipe);
    }
}
