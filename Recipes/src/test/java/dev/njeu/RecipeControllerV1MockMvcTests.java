//package com.example.demo;
//
//import com.example.demo.web.RecipeController;
//import com.example.demo.models.Recipe;
//import com.example.demo.services.RecipeService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//
//@WebMvcTest(RecipeController.class)
//public class RecipeControllerV1MockMvcTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private RecipeService recipeService;
//
//    @Test
//    @DisplayName("GET /api/recipe returns 200 OK and a valid JSON")
//    void getRecipe_returnsValidResponseEntity() throws Exception {
////        Recipe mockRecipe = Recipe.builder()
////                .name("Flying Dutchman")
////                .description("Ordinary Drink")
////                .ingredients("Gin, Triple sec")
////                .directions("In an old-fashioned glass almost filled with ice cubes, combine the gin and triple sec. Stir well.")
////                .build();
//        Recipe mockRecipe = new Recipe(
//                "Flying Dutchman",
//                "Ordinary Drink",
//                "Gin, Triple sec",
//                "In an old-fashioned glass almost filled with ice cubes, combine the gin and triple sec. Stir well.");
//        when(recipeService.getRecipe()).thenReturn(mockRecipe);
//
//        RequestBuilder requestBuilder = get("/api/recipe");
//
//        mockMvc.perform(requestBuilder)
//                .andExpectAll(
//                        status().isOk(),
//                        content().contentType(MediaType.APPLICATION_JSON),
//                        content().json("""
//                                {
//                                    "name": "Flying Dutchman",
//                                    "description": "Ordinary Drink",
//                                    "ingredients": "Gin, Triple sec",
//                                    "directions": "In an old-fashioned glass almost filled with ice cubes, combine the gin and triple sec. Stir well."
//                                }
//                                """)
//                );
//    }
//
//    @Test
//    @DisplayName("POST /api/recipe returns 200 OK and a valid JSON")
//    void postRecipe_returnsValidResponseEntity() throws Exception {
//        Recipe post = new Recipe(
//                "Brain Fart",
//                "Punch / Party Drink",
//                "Everclear, Vodka, Mountain Dew, Surge, Lemon juice, Rum",
//                "Mix all ingredients together. Slowly and gently. Works best if ice is added to punch bowl and soda's are very cold."
//        );
//        when(recipeService.createRecipe(post)).thenReturn(post);
//
//        String json = String.format("""
//                {
//                    "name":"%s",
//                    "description":"%s",
//                    "ingredients":"%s",
//                    "directions":"%s"
//                }
//                """, post.getName(), post.getDescription(), post.getIngredients(), post.getDirections());
//
//        mockMvc.perform(post("/api/recipe")
//                        .contentType("application/json")
//                        .content(json))
//                .andExpect(status().isOk());
//    }
//}
