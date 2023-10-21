package com.example.demo;

import com.example.demo.controllers.RecipeController;
import com.example.demo.exceptions.RecipeNotFoundException;
import com.example.demo.models.Recipe;
import com.example.demo.services.RecipeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecipeController.class)
public class RecipeControllerV2MockMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    @Test
    @DisplayName("GET /api/recipe/1 returns 200 OK and a valid JSON")
    void shouldFindRecipeWhenGivenValidID() throws Exception {
        Recipe mockRecipe = Recipe.builder()
                .name("Flying Dutchman")
                .description("Ordinary Drink")
                .ingredient("Gin")
                .ingredient("Triple sec")
                .direction("In an old-fashioned glass almost filled with ice cubes")
                .direction("combine the gin and triple sec")
                .direction("Stir well")
                .build();

        when(recipeService.getRecipe(1)).thenReturn(mockRecipe);

        RequestBuilder getRequest = get("/api/recipe/1");

        mockMvc.perform(getRequest)
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().json("""
                                {
                                    "name": "Flying Dutchman",
                                    "description": "Ordinary Drink",
                                    "ingredients": ["Gin", "Triple sec"],
                                    "directions": ["In an old-fashioned glass almost filled with ice cubes", "combine the gin and triple sec", "Stir well"]
                                }
                                """)
                );
    }

    @Test
    @DisplayName("GET /api/recipe/999 returns 404 not found")
    void shouldNotFindRecipeWhenGivenInvalidID() throws Exception {
        when(recipeService.getRecipe(999)).thenThrow(RecipeNotFoundException.class);

        mockMvc.perform(get("/api/recipe/999"))
                .andExpect(status().isNotFound());
    }
}
