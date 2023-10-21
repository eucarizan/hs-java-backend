package com.example.demo;

import com.example.demo.controllers.RecipeController;
import com.example.demo.models.Recipe;
import com.example.demo.services.RecipeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecipeController.class)
public class RecipeControllerV2MockMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    @Test
    @DisplayName("GET /api/recipe/1 returns 200 OK and a valid JSON")
    void getRecipeById_returnsValidResponseEntity() throws Exception {
//        Recipe mockRecipe

        RequestBuilder getRequest = get("/api/recipe/1");

        mockMvc.perform(getRequest)
                .andExpect(status().isOk());
    }
}
