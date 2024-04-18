package dev.njeu.web.mapper;

import dev.njeu.entities.Recipe;
import dev.njeu.entities.User;
import dev.njeu.web.dto.RecipeDto;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapper {

    public RecipeDto toDto(Recipe recipe) {
        return new RecipeDto(recipe.getName(), recipe.getCategory(), recipe.getDateTime(),
                recipe.getDescription(), recipe.getIngredients(), recipe.getDirections());
    }

    public Recipe toEntity(RecipeDto recipeDto, User user) {
        return new Recipe().setName(recipeDto.name())
                .setCategory(recipeDto.category())
                .setDescription(recipeDto.description())
                .setIngredients(recipeDto.ingredients())
                .setDirections(recipeDto.directions())
                .setCreator(user);
    }
}
