package dev.njeu.service.impl;

import dev.njeu.entities.Recipe;
import dev.njeu.exceptions.NotOwnerException;
import dev.njeu.exceptions.RecipeNotFoundException;
import dev.njeu.repositories.RecipeRepository;
import dev.njeu.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository repository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Recipe getById(long id) throws RecipeNotFoundException {
        return repository.findById(id).orElseThrow(() -> createNotFoundException(id));
    }

    @Override
    public Recipe add(Recipe recipe) {
        return repository.save(recipe);
    }

    @Override
    public void delete(long id, String username) throws RecipeNotFoundException, NotOwnerException {
        repository.findById(id)
                .ifPresentOrElse(recipe -> executeIfOwnerOrThrow(recipe, repository::delete, username),
                        () -> {
                            throw createNotFoundException(id);
                        });
    }

    @Override
    public void update(long id, Recipe updateRecipe, String sessionUsername) throws RecipeNotFoundException, NotOwnerException {
        repository.findById(id)
                .ifPresentOrElse(recipe -> executeIfOwnerOrThrow(recipe, getUpdateAction(updateRecipe), sessionUsername),
                        () -> {
                            throw createNotFoundException(id);
                        });
    }

    @Override
    public List<Recipe> searchByCategory(String searchText) {
        return repository.findAllByCategoryEqualsIgnoreCaseOrderByDateTimeDesc(searchText);
    }

    @Override
    public List<Recipe> searchByName(String searchText) {
        return repository.findAllByNameContainsIgnoreCaseOrderByDateTimeDesc(searchText);
    }

    private void executeIfOwnerOrThrow(Recipe recipe, Consumer<Recipe> action, String username) throws NotOwnerException {
        if (recipe.getCreator().getUsername().equals(username)) {
            action.accept(recipe);
        } else {
            throw new NotOwnerException();
        }
    }

    private RecipeNotFoundException createNotFoundException(long id) {
        return new RecipeNotFoundException("recipe with id %d not found".formatted(id));
    }

    private Consumer<Recipe> getUpdateAction(Recipe updateRecipe) {
        return recipe -> {
            updateRecipe.setId(recipe.getId());
            repository.save(updateRecipe);
        };
    }
}
