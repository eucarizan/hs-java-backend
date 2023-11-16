package com.example.demo;


import com.example.demo.controllers.RecipeController;
import com.example.demo.dtos.CreateRecipeDTO;
import com.example.demo.exceptions.RecipeNotFoundException;
import com.example.demo.models.Recipe;
import com.example.demo.services.RecipeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecipeController.class)
@AutoConfigureMockMvc
public class RecipeControllerV3MockMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    @Test
    @DisplayName("GET /api/recipe/1 returns 200 OK and a valid JSON")
    void shouldFindRecipeWhenGivenValidID() throws Exception {
        String name = "Flying Dutchman";
        String description = "Ordinary Drink";
        List<String> ingredient = List.of("Gin", "Triple sec");
        List<String> direction = List.of("In an old-fashioned glass almost filled with ice cubes", "combine the gin and triple sec", "Stir well");

        Recipe mockRecipe = new Recipe(null, name, description, ingredient, direction);

        when(recipeService.findById(1)).thenReturn(Optional.of(mockRecipe));

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
        when(recipeService.findById(999)).thenThrow(RecipeNotFoundException.class);

        mockMvc.perform(get("/api/recipe/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /api/recipe/new returns 200 OK and a valid JSON")
    void shouldCreateANewRecipe() throws Exception {
        String name = "Brain Fart";
        String description = "Punch / Party Drink";
        List<String> ingredients = List.of("Everclear", "Vodka", "Mountain Dew", "Surge", "Lemon juice", "Rum");
        List<String> directions = List.of("Mix all ingredients together", "Slowly and gently",
                "Works best if ice is added to punch bowl and soda's are very cold");

        Recipe post = new Recipe(null, name, description, ingredients, directions);

        CreateRecipeDTO recipeDTO = new CreateRecipeDTO(1);

        when(recipeService.createRecipe(post)).thenReturn(ResponseEntity.ok(recipeDTO));

        String json = String.format("""
                        {
                            "name": "%s",
                            "description": "%s",
                            "ingredients": [%s],
                            "directions": [%s]
                        }
                        """,
                post.name(),
                post.description(),
                "\"Everclear\", \"Vodka\", \"Mountain Dew\", \"Surge\", \"Lemon juice\", \"Rum\"",
                "\"Mix all ingredients together\", \"Slowly and gently\", " +
                        "\"Works best if ice is added to punch bowl and soda's are very cold\"");

        mockMvc.perform(post("/api/recipe/new")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());
    }

}
