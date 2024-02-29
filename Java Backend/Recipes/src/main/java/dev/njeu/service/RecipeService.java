package dev.njeu.service;

import dev.njeu.entities.Recipe;
import dev.njeu.exceptions.NotOwnerException;
import dev.njeu.exceptions.RecipeNotFoundException;

import java.util.List;

public interface RecipeService {

    /**
     * find and retrieve recipe with given id
     *
     * @return the found recipe
     * @throws RecipeNotFoundException if no recipe with id is found
     */
    Recipe getById(long id) throws RecipeNotFoundException;

    /**
     * save given Recipe to the repository.
     *
     * @return saved recipe enriched with id.
     */
    Recipe add(Recipe recipe);

    /**
     * delete recipe with given id if it exists
     *
     * @param id              of recipe to delete
     * @param sessionUsername username of authenticated originator of the request
     * @throws RecipeNotFoundException if no recipe with id is found
     * @throws NotOwnerException       if the authenticated session user is not the owner of the recipe
     */
    void delete(long id, String sessionUsername) throws RecipeNotFoundException, NotOwnerException;

    /**
     * update recipe with given id if it exists to the new updateRecipeDto data given
     *
     * @param id              of recipe to update
     * @param updateRecipe    recipe data, to which the recipe gets updated
     * @param sessionUsername username of authenticated originator of the request
     * @throws RecipeNotFoundException if no recipe with id is found
     * @throws NotOwnerException       if the authenticated session user is not the owner of the recipe
     */
    void update(long id, Recipe updateRecipe, String sessionUsername) throws RecipeNotFoundException, NotOwnerException;

    /**
     * case-insensitive search for recipes with given category search text
     *
     * @param searchText category to search for
     * @return list of matching Recipe's
     */
    List<Recipe> searchByCategory(String searchText);

    /**
     * case-insensitive search for recipes with given name search text
     *
     * @param searchText name sub string to search for (contains)
     * @return list of matching Recipe's
     */
    List<Recipe> searchByName(String searchText);
}
