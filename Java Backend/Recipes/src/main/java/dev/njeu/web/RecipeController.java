package dev.njeu.web;

import dev.njeu.entities.User;
import dev.njeu.service.RecipeService;
import dev.njeu.web.dto.RecipeDto;
import dev.njeu.web.mapper.RecipeMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private final RecipeService service;
    private final RecipeMapper mapper;

    @Autowired
    public RecipeController(RecipeService recipeService, RecipeMapper recipeMapper) {
        this.service = recipeService;
        this.mapper = recipeMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<Map<String, Long>> addRecipe(@Valid @RequestBody RecipeDto recipeDto,
                                                       @AuthenticationPrincipal User user) {
        var saved = service.add(mapper.toEntity(recipeDto, user));
        return ResponseEntity.ok(Collections.singletonMap("id", saved.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> getRecipe(@PathVariable long id) {
        return ResponseEntity.ok(mapper.toDto(service.getById(id)));
    }

    @GetMapping(value = "/search", params = "name")
    public ResponseEntity<RecipeDto[]> getRecipesByName(@RequestParam String name) {
        var foundRecipes = service.searchByName(name);
        return ResponseEntity.ok(foundRecipes.stream().map(mapper::toDto).toArray(RecipeDto[]::new));
    }

    @GetMapping(value = "/search", params = "category")
    public ResponseEntity<RecipeDto[]> getRecipesByCategory(@RequestParam String category) {
        var foundRecipes = service.searchByCategory(category);
        return ResponseEntity.ok(foundRecipes.stream().map(mapper::toDto).toArray(RecipeDto[]::new));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable long id,
                                             @AuthenticationPrincipal User user) {
        service.delete(id, user.getUsername());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRecipe(@PathVariable long id,
                                             @Valid @RequestBody RecipeDto recipeDto,
                                             @AuthenticationPrincipal User user) {
        service.update(id, mapper.toEntity(recipeDto, user), user.getUsername());
        return ResponseEntity.noContent().build();
    }

    // TODO: extra - create data.sql to insert data to DB
}
