package dev.njeu.service;

import dev.njeu.entities.Recipe;
import dev.njeu.exceptions.NotOwnerException;
import dev.njeu.exceptions.RecipeNotFoundException;

import java.util.List;

public interface RecipeService {
    Recipe getById(long id) throws RecipeNotFoundException;

    Recipe add(Recipe recipe);

    void delete(long id, String sessionUsername) throws RecipeNotFoundException, NotOwnerException;

    void update(long id, Recipe recipe, String sessionUsername) throws RecipeNotFoundException, NotOwnerException;

    List<Recipe> searchByCategory(String searchText);

    List<Recipe> searchByName(String searchText);
}
